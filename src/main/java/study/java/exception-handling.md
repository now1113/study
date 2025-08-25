# Exception Handling

## 목적과 철학
- 예외는 **정상 흐름이 아닌 비정상 상황**을 알리기 위한 메커니즘.
- 핵심 원칙
  - **예외는 예외적인 상황에만 사용**한다. (제어 흐름에 쓰지 말자)
  - **복구 가능하면 Checked**, 프로그래밍 오류는 **Unchecked(Runtime)**
  - **표준 예외를 우선 사용**하고, 필요할 때만 **도메인 예외**를 만든다.
  - **원인(cause) 보존**과 **맥락 포함 메세지**가 필수.
  - **실패 원자성(failure atomicity)을 지켜** 부분 상태 깨짐을 피한다.

## 예외 계층 구조
```text
Throwable
├─ Error                // 복구 불가. VM/환경 문제(OutOfMemoryError 등)
└─ Exception
   ├─ (Checked)        // 호출자에게 처리를 강제: try-catch 또는 throws
   │  ├─ IOException, SQLException, TimeoutException ...
   └─ RuntimeException // Unchecked, 프로그래밍 오류/계약 위반
      ├─ NullPointerException, IllegalArgumentException,
      │  IllegalStateException, IndexOutOfBoundsException,
      │  UnsupportedOperationException, ArithmeticException ..
```
- **Checked**: 파일/네트워크/DB 등 **경계 I/O**에서 자주 발생, **복구/대체 경로**가 의미 있을 때
- **Runtime**: **버그/계약 위반**(잘못된 인수, 상태 위반, 불변식 깨짐 등)

## 표준 예외 매핑 가이드
| 상황          | 표준 예외(권장)                                         | 비고                      |
| ----------- | ------------------------------------------------- | ----------------------- |
| 잘못된 인자 값    | `IllegalArgumentException`                        | 범위/형식 위반                |
| 호출 순서/상태 위반 | `IllegalStateException`                           | 준비/초기화 미흡 등             |
| null 인자     | `NullPointerException` 또는 `IAE`                   | 명시 검사면 IAE도 OK          |
| 인덱스 범위      | `IndexOutOfBoundsException`                       | List/Array 인덱스          |
| 미지원 연산      | `UnsupportedOperationException`                   | 불변/읽기전용 컬렉션 등           |
| 요소 없음       | `NoSuchElementException`                          | Iterator/Optional.get() |
| I/O 경계      | `IOException`, `UncheckedIOException`             | 스트림/파일                  |
| 파싱 실패       | `NumberFormatException`, `DateTimeParseException` |                         |

## 예시

### 예외로 제어 흐름 만들지 않기
```java
public class ControlFlowVsException {

    static void bad() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);

        try {
            while (true) {
                Integer value = queue.remove();
                System.out.println("[bad] polled=" + value);
            }
        } catch (Exception e) {
            System.out.println("[bad] stopped by exception: " + e.getClass().getSimpleName());
        }
    }

    static void good() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        Integer v;

        while ((v = queue.poll()) != null) {
            System.out.println("[good] polled=" + v);
        }
        System.out.println("[good] finished without excpetion");
    }

    public static void main(String[] args) {
        bad();
        good();
    }
}
```
- bad는 예외로 종료
- good은 정상 종료

### 원인(cause) 보존 & 맥락 포함 (Checked → Unchecked 변환)
```java
public class WrapCause {
    private static final String orderNo = "ORD-123";
    private static final Path path = Path.of("NO_SUCH_FILE.txt");

    static void readAndPrint() {
        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            throw new UncheckedIOException("fail to read file for orderNo="+ orderNo, e);
        }
    }

    public static void main(String[] args) {
        readAndPrint();
    }
}
```
- 실행시 `UnCheckedIOException`이 발생하며, `cause`에 `NoSuchFileException` 포함.

### try-with-resources & suppressed 예외
```java
public class TryWithResourcesSuppressed {
    static class FragileResource implements AutoCloseable {
        @Override
        public void close() throws Exception {
            throw new Exception("close failed");
        }
    }

    public static void main(String[] args) {
        try (FragileResource r = new FragileResource()) {
            throw new Exception("work failed");
        } catch (Exception e) {
            System.out.println("primary: " + e.getMessage());
            for (Throwable throwable : e.getSuppressed()) {
                System.out.println("suppressed: " + throwable.getMessage());
            }
        }
    }
}
```
출력
```text
primary: work failed
suppressed: close failed
```

- **주 예외(primary)**: `try` 블록에서 처음 발생한 예외.
- **억제된 예외(suppressed)**: `try` 블록에서 이미 예외가 발생해 스택 언와인딩이 시작되었는데, **자원 해제(close)** 중 추가로 발생한 예외.
    이 예외는 **주 예외를 덮어쓰지 않고** `primary.addSuppressed(추가예외)`로 **부가정보**로 붙는다.

> 목적: **실패 원인(주 예외)을 잃지 않으면서**도 **자원 해제 중에도 문제가 있었다**는 사실을 함께 전달하기 위함.

> 스택 언와인딩: 프로그램 실행 중 **예외가 발생**했을 때, 해당 예외를 처리할 수 있는 **catch 블록**을 찾기 위해  
> 호출 스택을 역순으로 거슬러 올라가면서 지역 변수를 소멸시키고 함수의 시작 지점을 복원하는 과정을 말한다.

위 예제에서는 `try` 블록에서 **work failed** 예외가 던저짐 -> 스택 언와인딩 시작  
자바는 **리소스 자동 해제**를 위해 `r.close()`를 호출 -> `close()`에서 **close failed** 예외가 또 발생  
이미 **주 예외**가 있으므로 `close failed`는 **suppressed**로 **주 예외에 첨부**됨 (덮어쓰지 않음)  
`catch`로 넘어왔을 때 `e`는 **work failed**이고, `e.getSuppressed()`에 **close failed**가 들어있다.
