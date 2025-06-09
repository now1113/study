# GC(Garbage Collection)

## 개요

**Garbage Collection**은 프로그램 실행 중 **더 이상 사용되지 않는 객체를 자동으로 탐지하고 메모리에서 해제**하는 메커니즘이다.  
Java에서는 개발자가 명시적으로 `free()`나 `delete`같은 메모리 해제 코드를 작성할 필요가 없으며, JVM이 자동으로 이를 수행한다.


## 필요한 이유
| 이유            | 설명                                      |
| ------------- | --------------------------------------- |
| **메모리 누수 방지** | 수동 해제를 놓치면 계속 메모리 점유 → OutOfMemoryError |
| **안정성 향상**    | 잘못된 포인터 해제(Bad Access)로 인한 오류를 방지       |
| **생산성 향상**    | 개발자가 메모리 관리를 직접 하지 않아도 됨                |

## Garbage의 정의
JVM 입장에서 **더 이상 참조되지 않는 객체**가 Garbage다.

```java
public class Example {
    public static void main(String[] args) {
        String s = new String("hello");
        s = null;   // "hello" 객체는 이제 참조되지 않음 -> Garbage 대상
    }
}
```

## 참조 기준
JVM은 아래 중 **어느 하나라도 참조하고 있으면 살아있는 객체로 간주**한다.
- **GC Root에서 도달 가능한 객체** (Reachability 기준)
  - 스레드 스택(Local 변수)
  - 메서드 파라미터
  - static 필드
  - JNI 참조

이와 같은 GC ROOT로부터 도달할 수 없는 객체들은 수집 대상이 된다.

## GC Root (Garbage Collection Root)
`GC Root`는 JVM이 객체 생존 여부를 판단할 때 시작하는 **기준점** 이다.  
GC는 이 GC Root에서부터 **객체 그래프를 따라가며 도달할 수 있는 모든 객체를 살아있는 객체**로 간주한다.  
도달할 수 없는 객체만이 GC의 대상이 된다.

### GC Root의 종류
| 구분                                      | 설명                                            |
| --------------------------------------- | --------------------------------------------- |
| **1. 스레드 스택(Thread Stack)**             | 현재 실행 중인 스레드의 지역 변수(Local Variable), 메서드 파라미터 |
| **2. 메서드 영역의 static 필드**                | 클래스의 static으로 선언된 변수들                         |
| **3. 메서드 영역의 클래스 객체**                   | `ClassLoader`에 로드된 클래스 자체 (메타 정보)             |
| **4. JNI(Global References)**           | 네이티브 코드(C/C++)가 참조 중인 Java 객체                 |
| **5. 활동 중인 스레드(Active Thread)**         | 현재 실행 중인 모든 스레드는 GC Root로 간주됨                 |
| **6. 동기화 모니터(Monitor Held by Threads)** | `synchronized` 블록/메서드에서 획득한 모니터               |
| **7. JVM 내부 구조 참조**                     | 시스템 클래스 로더, JIT 캐시 등 JVM 내부에서 관리하는 특별한 참조     |

### 간단한 객체 그래프
```text
GC Root
  │
  ├──> obj1
  │     └──> obj2
  │           └──> obj3
  │
  └──> obj4

obj5 ← 참조 없음 → GC 대상
```
- `obj1 ~ obj4`는 GC Root에서 도달 가능 -> **살아 있음**
- `obj5`는 어떠한 GC Root도 참조하지 않음 -> **Garbage 대상**

### 예제
```java
public class GCRootExample {
    private static GCRootExample staticField;

    public static void main(String[] args) {
        GCRootExample localVar = new GCRootExample();   // Local 변수 -> stack Root
        staticField = new GCRootExample();  // Static 필드 -> GC Root
        GCRootExample obj = new GCRootExample();    // 이후 참조 끊기면 GC 대상
        
        obj = null; // 이 객체는 Root에서 도달 불가 -> GC 대상
    }
}
```
| 객체            | GC Root? | 설명                       |
| ------------- |----------| ------------------------ |
| `localVar`    | O        | 메서드 내 지역 변수(Stack Frame) |
| `staticField` | O        | 클래스 static 필드            |
| `obj`         | X        | 참조 해제됨 → GC 대상           |

### GC Root가 중요한 이유
- GC는 전체 Heap을 전부 순회하지 않는다.
  - **GC Root에서 시작해서 도달 가능한 객체만 탐색**하여 비용을 줄임
- 객체가 살아있느냐 죽었느냐는 **GC Root에 직접 또는 간접적으로 연결되었느냐**로 결정됨
- `WeakReference`, `PhantomReference`등은 GC Root의 Reachability와 연관된 **정밀한 메모리 관리 도구**로 연결됨

### 정리
- GC Root는 GC의 시작점으로, **객체 생존 여부의 기준**
- GC Root는 메서드 스택, static 필드, native 참조 등 여러 종류가 있음
- GC는 이들로부터 **Reachable한 객체만을 살려두고**, 나머지는 수거함
- **Reference Graph + Reachability** 개념이 GC 전반을 이해하는 핵심 포인트


## GC의 주요 목표
| 항목               | 설명                             |
| ---------------- | ------------------------------ |
| **메모리 회수**       | 유효하지 않은 객체의 메모리 회수             |
| **애플리케이션 성능 유지** | 잦은 Full GC를 피하고 pause time 최소화 |
| **Heap 공간 재사용**  | 효율적인 공간 관리로 OOM 방지             |

## GC 관련 용어

| 용어                       | 설명                                            |
| ------------------------ | --------------------------------------------- |
| **Stop-The-World (STW)** | GC 수행 중 애플리케이션의 모든 스레드를 정지시킴                  |
| **Minor GC**             | Young 영역(Eden+Survivor)에서 발생하는 GC             |
| **Major GC / Full GC**   | Old 영역 수집, 또는 전체 Heap 영역 수집                   |
| **Promotion**            | Young → Old 영역으로 객체를 이동시키는 과정                 |
| **Finalization**         | 객체가 GC 대상일 때 `finalize()` 메서드를 호출할 수 있음 (비추천) |

## 요약
- Java의 GC는 **개발자가 명시적으로 메모리 해제를 하지 않아도 되도록 해주는 시스템**
- 참조가 끊긴 객체를 자동으로 탐지해서 제거
- GC는 애플리케이션을 멈추고 동작하며, 이를 최소화하는 것이 GC 성능 튜닝의 핵심
- GC Root를 기준으로 도달 불가능한 객체가 수거 대상


## 동작 방식

### Heap 구조와 영역 분할
JVM의 Heap 영역은 GC가 관리하는 메모리이며, 다음과 같이 나뉜다.
```text
[ Young Generation ]       [ Old Generation ]
┌───────────────┐          ┌───────────────┐
│ Eden Space    │ ─────┐   │  Tenured/Old  │
├───────────────┤      └─> │   Generation  │
│ Survivor S0   │          └───────────────┘
├───────────────┤
│ Survivor S1   │
└───────────────┘
```
| 영역                    | 설명                                |
| --------------------- | --------------------------------- |
| **Eden**              | 대부분의 객체가 처음 생성되는 공간               |
| **Survivor (S0, S1)** | Eden에서 살아남은 객체가 일시적으로 머무는 공간      |
| **Old (Tenured)**     | 오랫동안 살아남은 객체가 올라가는 공간 (promotion) |

### Minor GC vs Major GC (Full GC)
| GC 종류        | 대상                         | 특징                           |
| ------------ | -------------------------- | ---------------------------- |
| **Minor GC** | Young Generation           | 빠르고 자주 발생, Stop-The-World 발생 |
| **Major GC** | Old Generation             | 상대적으로 느림, STW 시간 김           |
| **Full GC**  | Young + Old + Metaspace 전체 | 가장 무거움, 불필요하게 발생하면 성능 이슈     |


### 객체의 생존과 이동 (Promotion)
- 대부분의 객체는 **Eden**에서 생성됨
- Minor GC 시, **참조가 남아있는 객체만** Survivor로 이동
- **몇 번의 Minor GC 동안 살아남은 객체**는 Old 영역으로 **Promote**

JVM 옵션 `-XX:MaxTenuringThreshold=15`는 몇 번의 GC 후 Old 영역으로 승격시킬지 결정

### GC의 동작 흐름 (Minor GC 기준)
- **Minor GC 발생 트리거**
  - Eden 공간이 꽉 찼을 때
- **Copying 방식 수행**
  - Eden에 있는 살아있는 객체를 Survivor로 **copy**
  - 이전 Survivor에 있던 객체는 연령(age)을 증가시켜 재복사 또는 Old로 Promote
- **Eden 공간 전체 정리**
  - Eden 내의 모든 객체는 수집 대상이 되거나 Survivor로 이동

```text
[Before GC]
Eden: obj1, obj2
S0: (empty)
S1: obj3 (age=1)

[After GC]
Eden: (empty)
S0: obj1 (age=1), obj3 (age=2)
S1: (empty)
→ obj2는 참조 끊겼으므로 GC
```

### Stop-The-World
GC 수행 중 JVM이 모든 애플리케이션 스레드를 **정지(STW)** 시키는 현상.
- Minor GC, Major GC, Full GC 모두 STW 발생
- GC 시간이 길수록, STW 시간이 길어짐 -> 애플리케이션 응답 지연 원인


### 메모리 회수 방식: Mark & Sweep vs Copying vs Compacting
| 알고리즘             | 설명                              | 사용 영역                        |
| ---------------- | ------------------------------- | ---------------------------- |
| **Mark & Sweep** | 도달 가능한 객체(Mark) → 나머지 제거(Sweep) | Old Generation (Serial, CMS) |
| **Copying**      | 살아있는 객체를 다른 공간으로 복사             | Young Generation             |
| **Mark-Compact** | Mark 후 살아있는 객체를 좌측으로 정렬         | G1, ZGC 등                    |


### 객체 생존 조건 (Reachability 기준)
- GC Root에서 직접 또는 간접적으로 참조 가능해야 함
- 참조가 끊기면 다음 GC에서 제거 대상
- `finalize()`가 있는 객체는 한 번 유예됨

### 예제: 객체가 Eden -> Survivor -> Old로 가는 흐름
```java
for (int i = 0; i < 1000; i++) {
    byte[] data = new byte[1024 * 512]; // 512KB 객체 생성
}
```
- 다수의 객체가 Eden에 생성 -> Eden 가득 차면 Minor GC 발생
- 일부 객체가 계속 참조 중이면 Survivor로 이동
- 계속해서 살아남으면 Old 영역으로 Promotion
- 메모리 부족 시 Major GC / Full GC 발생

### 정리
- JVM Heap은 Young(=Eden + Survivor)과 Old로 나뉘며 GC는 이 구조를 기반으로 동작
- Minor GC는 Young 영역 대상, Major GC는 Old 영역 대상
- 대부분의 객체는 Young에서 생성되고 대부분 바로 사라짐
- 살아남은 객체는 Promotion되고, 오래 살아남을수록 GC 대상이 되기 어려움
- GC의 핵심은 **Copying 방식, STW 시간 최소화, 적절한 Promotion**

