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
