## JVM (Java Virtual Machine)

### Q. JVM, JRE, JDK는 각각 어떤 역할을 하나요?

- **JVM (Java Virtual Machine)** : 자바 바이트코드를 실행하는 가상 머신. OS에 독립적인 실행 환경 제공.
- **JRE (Java Runtime Environment)** : JVM + 자바 표준 라이브러리. 자바 애플리케이션 실행을 위한 환경
- **JDK (Java Development Kit)** : JRE + 개발 도구(컴파일러 `javac`, `디버거` 등) 개발에 필요한 모든 요소 포함

### Q. JVM은 무엇인가요?

- JVM은 **자바 바이트코드(.class)를 읽고 실행하는 가상 머신(Virtual Machine)이다.**
- 플랫폼에 독립적으로 실행할 수 있도록 해주며, 자바의 `Write Once, Run Anywhere`개념을 가능하게 한다.
- 운영체제와 프로그램 사이에서 **추상화된 실행 환경**을 제공한다.

### Q. JVM은 어떤 구조로 되어 있나요?

- **Class Loader**
  - `.class`파일을 읽어 들여 **메모리에 로드**한다.
  - **로딩 -> 링크(Linking) -> 초기화** 단계로 구성됨
- **Runtime Data Area (실행 중 할당되는 메모리 영역)**
  - **Heap**: 객체가 저장되는 영역(GC 대상)
  - **Stack**: 메서드 호출 프레임 저장, 지역 변수 포함
  - **Method Area**: 클래스 정보, static 변수, 메서드 코드 등 저장
  - **Native Method Stack**: C/C++ 등의 네이티브 메서드 호출 시 사용
- **Execution Engine**
  - **Interpreter**: 바이트코드를 한 줄씩 해석하여 실행
  - **JIT Compiler (Just-In-Tine)**: 반복 실행되는 코드를 **기계어로 변환하여 캐싱**, 속도 향상
- **Garbage Collector (GC)**
  - 사용하지 않는 객체를 **자동으로 메모리에서 제거**

### Q. 자바는 왜 플랫폼 독립적인가요

- 자바는 **컴파일 시 .class 바이트코드**로 변환되며,
- 각 플랫폼마다 제공되는 JVM이 바이트코드를 **해석/실행**해준다.
- 즉, OS별로 JVM만 다르면 자바 코드는 그대로 실행 가능하다.
  - 이것이 **Write Once, Run Anywhere**의 본질

### Q. JVM에서 GC는 어떤 역할을 하나요?

- GC(Garbage Collector)는 JVM의 **Heap 메모리 관리 도구**다.
- 참조되지 않는 객체를 **자동으로 탐지하여 제거**해 메모리를 회수한다.
- GC는 크게 **Mark-Sweep-Compact 알고리즘** 기반으로 동작하며,
  - Java 8: CMS, G1GC
  - Java 9+: 기본 GC는 **G1GC**
  - Java 11~17: ZGC, Shenandoah 등 추가

### Q. JDK 없이 자바 프로그램 실행이 가능한가요?

- `.class`파일이 있다면 **JRE만으로 실행 가능**
- 그러나 **소스 코드(.java)를 컴파일하려면 JDK 필요**

## 자바의 메모리 구조

### Q. 자바에서 사용하는 메모리 영역은 어떻게 나뉘나요?

A. JVM은 실행 시 다음과 같은 **Runtime Data Area**를 구성한다

| 영역                      | 설명                                  |
| ----------------------- | ----------------------------------- |
| **Heap**                | 객체가 저장되는 공간. GC 대상. 모든 쓰레드가 공유      |
| **Stack**               | 각 쓰레드마다 생성되는 공간. 메서드 호출 시 프레임 생성    |
| **Method Area**         | 클래스 메타정보(클래스명, 메서드, static 변수 등) 저장 |
| **PC Register**         | 각 쓰레드가 **현재 실행 중인 명령 주소** 저장        |
| **Native Method Stack** | C/C++ 등의 **native 메서드** 실행 시 사용됨    |


### Q. Heap과 Stack의 차이는 무엇인가요?

| 항목        | Heap      | Stack                 |
| --------- | --------- | --------------------- |
| 저장 내용     | 인스턴스(객체)  | 지역 변수, 매개변수, 리턴 주소    |
| 접근 방식     | 동적 할당     | LIFO (Last-In, First-Out) |
| GC 대상 여부  | 예         | 아니오                   |
| 쓰레드 공유 여부 | 모든 쓰레드 공유 | 쓰레드별 분리               |
| 성능        | 상대적으로 느림  | 빠름 (메서드 호출/종료 시 자동 관리) |


### Q. 메서드 영역(Method Area)은 어떤 역할을 하나요?

- 클래스 로딩 시 해당 클래스의 **구조 정보, static 변수, 메서드 코드** 등을 저장한다.
- 예전에는 **PermGen** 영역이라고 불렸으나, Java 8부터 **Metaspace**로 대체됨 (native memory 사용)
- PermGen은 **OutOfMemoryError** 발생 위험이 있었으나 Metaspace는 자동 확장 가능


### Q. 자바에서 메모리 누수가 발생할 수 있나요?

가능함. GC가 자동으로 메모리를 관리하긴 하지만 참조가 남아 있는 객체는 GC 대상이 아님.

### Q. 자바에서 OutOfMemoryError가 나는 경우는?

- **Heap 공간 부족**: 객체를 너무 많이 생성했거나 누수 발생
- **Metaspace 부족**: 클래스 동적 로딩을 너무 많이 한 경우
- **StackOverflowError**: 재귀 호출이 너무 깊을 때

### 정리

```scss
JVM Memory
├── Heap (객체 저장)
├── Method Area (클래스, static 등)
├── Stack (지역 변수, 호출 프레임)
├── PC Register (명령 주소 추적)
└── Native Method Stack (JNI 호출용)
```

## Call by Value vs Call by Reference - 자바는 어떤가

### Q. 자바는 Call by Value 인가요? Reference 인가요?

- **자바는 무조건 Call by Value(값에 의한 전달)이다.**
- 변수의 값 자체(복사본)을 전달한다.
- 다만, 객체의 경우 **참조값(reference)의 복사본**이 전달되므로 헷갈리기 쉬움.

### Q. 객체를 메서드에 넘기면, 내부에서 변경 가능한가요?

- 객체의 **내부 상태(필드)는 변경 가능**하다.
  - 참조 주소가 복사되었기 때문에, **같은 객체를 가리키고 있음**
- 하지만 **참조 자체를 다른 객체로 바꿔도 원본엔 영향 없음**

```java
void modify(User user) {
    user.setName("홍길동");
    user = new User("임꺽정"); // 참조 변경 -> 호출자에 영향 없음
}
```

### Q. 자바에서 진짜 Call by Reference 방식은 불가능한가요?

- 그렇다. **Call by Reference는 변수의 주소 자체를 넘기는 방식**인데, 자바는 그걸 직접 지원하지 않음
  - 즉 **메서드에서 호출자의 변수 자체를 바꾸는 것은 불가능**

### Q. 왜 헷갈릴 수 있나요?

- 객체를 넘길 때 참조값이 넘어가기 때문에, 마치 참조를 넘기는 것처럼 **내부가 바뀌는 걸 보고 착각하기 쉬움.**


### 정리

| 타입             | Call by    | 메서드 안에서 값 변경 | 원본 영향 여부 |
| -------------- | ---------- | ---------- | ---- |
| int, boolean 등 | Value      | 값 자체 변경    | 없음   |
| 객체             | 참조값의 Value | 내부 변경      | 있음   |
| 객체             | 참조 자체 변경   | 없음         |      |


## 객체지향의 4대 특성

1. 캡슐화 (Encapsulation)
2. 상속 (Inheritance)
3. 다형성 (Polymorphism)
4. 추상화 (Abstraction)

### 캡슐화 (Encapsulation)

- **정의**: 데이터(필드)와 데이터를 처리하는 행위(메서드)를 하나의 클래스로 묶고, 외부에 일부만 공개하는 것
- **자바에서의 구현 방법**
  - 필드에 `private` 접근 제어자 사용
  - `public` getter/setter 메서드를 통해 접근 허용
- 이유: 무분별한 접근을 방지하고, 객체의 상태를 일관성 있게 유지하기 위함

```java
public class User {
    private String name;

  public String getName() {
      return name;
  }

  public void setName(String name) {
    if (name != null && !name.isBlank()) {
        this.name = name;
    }
  }
}
```

- Java 14+의 `record`는 불변 객체에 캡슐화 개념을 간단히 적용 가능

### 상속 (Inheritance)

- **정의**: 기존 클래스를 확장하여 새로운 클래스를 만드는 것
- **자바에서의 구현 방법**: `extends` 키워드 사용

```java
public class Animal {
  public void sound() {
    System.out.println("sound");
  }
}

public class Dog extends Animal {
  @Override
  public void sound() {
    System.out.println("멍멍");
  }
}
```

- 주의 사항
  - 단일 상속만 지원 (`extends`는 하나의 클래스만 상속 가능)
  - 코드 재사용은 되지만, 과도한 상속은 오히려 유지보수 어려움

### 다형성 (Polymorphism)

- **정의**: 하나의 객체가 여러 형태를 가질 수 있는 것
- **자바에서의 구현 방법**
  - **상속 + 오버라이딩**
  - **인터페이스 + 구현 클래스**
  - **업캐스팅을 통해 부모 타입으로 자식 객체를 참조**

```java
public class Cat extends Animal {
  @Override
  public void sound() {
    System.out.println("야옹");
  }
}

public class Main {
  public static void main(String[] args) {
    Animal an1 = new Dog(); // 업 캐스팅
    Animal an2 = new Cat();

    an1.sound();
    an2.sound();
  }
}
```

- **유형**
  - **정적 다형성: 메서드 오버로딩 (컴파일 시 결정)**
  - **동적 다형성: 메서드 오버라이딩 (런타임 시 결정)**


### 추상화 (Abstraction)

- **정의**: 복잡한 로직은 숨기고, 필요한 것만 드러내는 것 (필요한 것만 인터페이스로 노출)
- **자바에서의 구현 방법**
  - `interface` 또는 `abstract class`로 정의
  - 메서드 시그니처만 정의하고, 구체 로직은 구현 클래스에서 작성

```java
public interface PaymentStrategy {
  void pay(int amount);
}

public class KakaoPay implements PaymentStrategy {
  @Override
  public void pay(int amount) {
    System.out.println("카카오페이");
  }
}
```

- 사용하는 이유
  - 클라이언트는 구체 구현을 몰라도 되고, 새로운 기능이 들어와도 OCP 원칙을 지킬 수 있음 (확장에는 열려있고, 수정에는 닫혀 있음)


## 클래스 / 객체

### static과 instance 차이

| 구분        | static                    | instance             |
| --------- |---------------------------|----------------------|
| 메모리 영역    | **메서드 영역** (Method Area) 에 저장 | **힙** (Heap) 에 저장        |
| 소속        | 클래스에 소속 (`클래스.변수/메서드`)    | 객체에 소속 (`객체.변수/메서드`) |
| 메모리 할당 시점 | 클래스 로딩 시 한 번만 할당됨         | 객체 생성 시마다 새로 할당됨     |
| 대표 키워드    | `static`                  | 없음 (기본)              |
| 접근 방법     | `클래스명.변수`, `클래스명.메서드()`   | `new` 생성 후 객체로 접근    |
| 사용 목적     | 공통된 값, 유틸성 메서드, 상태 공유 등   | 객체 고유의 상태나 동작 필요할 때  |


### static 예시

```java
public class Counter { 
  public static int count = 0;    // 클래스 변수 (공유)

  public Counter() {
      count++;
      this.id = count;
  }
}
```
```java
Counter c1 = new Counter();
Counter c2 = new Counter();

System.out.println(c1.id); // 1
System.out.println(c2.id); // 2
System.out.println(Counter.count); // 2 (공유 변수)
```

### static은 왜 쓸까

- **공통 상태를 관리할 때** -> ex) 전체 인스턴스 수, 전역 설정
- **공통 유틸 클래스** -> ex) `Math.random()`, `Collections.sort()`
- **객체 없이 호출하고 싶을 때** -> ex) `main()` 메서드

### instance는 왜 쓸까

- **객체 별로 고유한 상태를 가져야할 때**
- 예: `User` 클래스에서 `name`, `email` 같은 정보는 인스턴스마다 다름

```java
User u1 = new User("A");
User u2 = new User("B");
```

### 인터페이스 vs 추상 클래스

| 항목       | 인터페이스 (`interface`)                             | 추상 클래스 (`abstract class`) |
| -------- | ----------------------------------------------- | --------------------- |
| 목적       | **기능 명세 (역할 중심)**                               | **공통 로직 제공 (기반 클래스 역할)** |
| 다중 구현/상속 | 다중 구현 가능 (`implements`)                         | 단일 상속만 가능 (`extends`) |
| 메서드      | 기본적으로 모두 `추상 메서드` (JDK 8 이후 `default`, `static` 허용) | 추상 메서드와 일반 메서드 모두 선언 가능 |
| 필드 선언    | `public static final` 상수만 가능                    | 인스턴스 필드 선언 가능         |
| 생성자      | 없음                                              | 생성자 선언 가능             |
| 접근 제어자   | 모든 메서드/변수는 자동으로 `public`                        | 접근 제어자 자유롭게 사용 가능     |
| 사용 용도    | 역할, 규칙, 행동을 정의할 때                               | 공통 기능을 가진 상위 클래스를 만들 때 |


## Checked 예외 / Unchecked 예외

### 자바 예외 클래스 계층 구조

```text
Throwable
 ├─ Error (OutOfMemoryError 등 - 시스템 오류)
 └─ Exception
     ├─ Checked Exception (컴파일 시 체크됨)
     └─ Unchecked Exception (RuntimeException 계열)
```

### 차이 정리

| 항목          | Checked Exception           | Unchecked Exception                              |
| ----------- | --------------------------- | ------------------------------------------------ |
| 상속 대상       | `Exception`                 | `RuntimeException`                               |
| 예외 처리 강제 여부 | **try-catch 또는 throws 필수**  | 컴파일러 강제 없음 (선택)                                  |
| 발생 시점       | **컴파일 시점에 확인됨**             | **실행 시점(Runtime)에 발생**                           |
| 대표 예시       | `IOException`, `SQLException` | `NullPointerException`, `IllegalArgumentException` |
| 사용 목적       | **복구 가능한 예외 처리 (외부 환경)**    | **프로그래밍 실수, 버그 (논리 오류)**                         |
| 언제 사용하는가?   | 외부 리소스 관련: 파일, DB, 네트워크 등   | 내부 코드 오류, 잘못된 인자, 조건 위반 등                        |


### 언제 써야 할까

| 상황                                | 추천 예외 유형                              |
| --------------------------------- | ------------------------------------- |
| 네트워크 오류, 파일 없거나 읽기 실패             | Checked Exception                     |
| 잘못된 메서드 인자, NPE 가능성 등 코드 버그       | Unchecked Exception                   |
| 서비스 로직 조건 위반 (`만 14세 미만 가입 불가` 등) | Unchecked (ex. `IllegalStateException`) |


## String vs StringBuilder vs StringBuffer

### String (불변 객체, `immutable`)

```java
String str = "hello";
str += " world";
```

- `String`은 **불변 객체**라서 위 코드는 내부적으로 **새로운 문자열 객체를 매번 생성**함
- 변경 불가능 -> 성능 저하 가능

#### 문제점

```java
String result = "";
for (int i = 0; i < 10000; i++) {
    result += i;
}
```

- 위 코드는 매 반복마다 **새로운 String + StringBuilder 생성 + toString()** 수행됨
- 결국 **10000개 이상의 객체가 힙에 생성됨 -> 성능 저하 + GC 부하**

### StringBuilder (가변 객체, `mutable`)

```java
StringBuilder sb = new StringBuilder();
for (int i = 0; i < 10000; i++) {
    sb.append(i);
}
String result = sb.toString();
```

- 내부적으로 `char[]` 배열을 이용해 문자열을 저장하고, 배열이 꽉 차면 자동으로 늘림
- append 시 기존 객체에 덧붙임 -> **객체 재사용으로 성능 우수**
- **단일 스레드 환경**에서 가장 빠름


### StringBuffer (동기화 지원 버전)

```java
StringBuffer sb = new StringBuffer();
sb.append("hello").append(" world");
```
- `StringBuilder`와 거의 동일한 내부 구조
- 하지만 `append`, `insert` 등의 메서드가 `synchronized`로 되어 있음
- 멀티 스레드 환경에서도 **안전하게 사용 가능**
- 대신 **동기화로 인한 오버헤드 존재 -> 단일 스레드에서는 느림**

### 비교 요약

| 클래스           | 쓰레드 안전성 | 성능(빠름)  | 용도                           |
| ------------- | ----- | ------- | ---------------------------- |
| String        |  (불변) |  (가장 느림) | 문자열 변경이 거의 없는 경우             |
| StringBuilder | (비동기) |  (가장 빠름) | 문자열을 **빈번히 변경**할 때, 단일 스레드에서 |
| StringBuffer  |  (동기화) |  (중간 정도) | 멀티 스레드 환경에서 문자열을 변경할 때       |


### 컴파일러 최적화

```java
String str = "hello" + " world";
```

- **컴파일 타임에 상수로 병합**됨 -> `String str = "hello world";`

```java
String str = "hello";
str += " world";
```

- **Java 5 ~ 현재까지** 대부분의 컴파일러는 내부적으로 다음과 같이 변환

```java
StringBuilder sb = new StringBuilder("hello");
sb.append(" world");
String str = sb.toString();
```

- **간단한 문자열에는 `+` 연산자 사용해도 무방**
- 단, **루프 안에서의 `+` 사용은 `StringBuilder` 재사용이 불가능하므로 반드시 직접 사용해야 함**

### 정리

| 상황                    | 추천 클래스          | 이유                             |
| --------------------- | --------------- | ------------------------------ |
| 문자열 연결이 1\~2번 정도인 경우  | `String`        | 컴파일 타임 최적화됨                    |
| 문자열을 반복적으로 수정/추가      | `StringBuilder` | 가변 구조 + 빠름 (단일 스레드 기준)         |
| 멀티 스레드에서 문자열을 공유하며 수정 | `StringBuffer`  | 쓰레드 안전 보장 (`synchronized`) 사용됨 |
| 불변 문자열이 필요한 경우        | `String`        | 메모리 안전성, 해시코드 일관성 등에서 유리       |
