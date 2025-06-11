# JVM (Java Virtual Machine)

JVM은 **자바 바이트코드(.class)를 읽고 실행하는 가상 머신(Virtual Machine)이다.**  
플랫폼에 독립적으로 실행할 수 있도록 해주며, 자바의 `Write Once, Run Anywhere`개념을 가능하게 한다.  
운영체제와 프로그램 사이에서 **추상화된 실행 환경**을 제공한다.


## JDK, JRE, JVM

| 구성요소                               | 설명                                               |
| ---------------------------------- | ------------------------------------------------ |
| **JDK (Java Development Kit)**     | JRE + 개발 도구(컴파일러 javac, 디버거 등) 개발에 필요한 모든 요소 포함|
| **JRE (Java Runtime Environment)** |  JVM + 자바 표준 라이브러리. 자바 애플리케이션 실행을 위한 환경        |
| **JVM (Java Virtual Machine)**     | JRE + 개발 도구(컴파일러 javac, 디버거 등) 개발에 필요한 모든 요소 포함 |

### 구조 다이어그램

```markdown
 ┌──────────────┐
 │ ClassLoader  │ ← 클래스 로딩
 └─────┬────────┘
       ↓
 ┌─────▼────────┐
 │ Runtime Data │ ← 메모리 영역
 └─────┬────────┘
       ↓
 ┌─────▼────────┐
 │ Execution Eng│ ← 명령어 해석 + GC
 └─────┬────────┘
       ↓
 ┌─────▼────────┐
 │ Native Interf│ ← JNI
 └─────┬────────┘
       ↓
 ┌─────▼────────┐
 │ Native Method│ ← OS 의존 코드
 └──────────────┘
```

## ClassLoader

JVM이 `.class` 파일을 메모리에 적재할 때 사용하는 메커니즘.  
Java에서는 클래스를 **동적으로 로딩**하기 때문에, 로딩 방식은 매우 중요한 역할을 함.

### ClassLoader 동작 과정

클래스 로딩은 다음 세 단계를 거친다.

- **로딩(Loading)**: `.class`파일을 찾아서 읽어들임
- **링크(Linking)**
    - **검증(Verification)**: 바이트코드 형식 검증
    - **준비(Preparation)**: static 변수에 기본값 할당
    - **해결(Resolution)**: 심볼릭 레퍼런스를 실제 레퍼런스로 치환
- **초기화(Initialization)**: static 초기화 블럭 및 static 변수의 값 초기화

### 로딩 (Loading)

- 로딩은 JVM이 `.class` 파일을 찾아서 메모리로 읽어들이는 과정이다.
- 이 단계에서 실제 바이트코드(`.class`파일)가 메모리로 로드되어, **클래스 메타데이터와 클래스 정의**가 JVM으로 전달된다.
- `.class` 파일은 디스크에서 읽혀 JVM 메모리 영역으로 로드되고, 그 후에 **링크(Linking)** 와 **초기화(Initialization)** 단계로 넘어간다.

### 링크 (Linking)

링크 단계는 다시 세 가지 서브 단계로 나뉜다. **검증(Verification), 준비(Preparation), 해결(Resolution)**

#### 검증 (Verification)
- **검증(Verification)** 단계에서는 로드된 `.class` 파일이 유효한지, 즉 **자바 바이트코드 형식**이 올바른지 확인한다.
- 예를 들어, 메소드 호출 시 존재하지 않는 메서드를 호출하거나, 메모리를 잘못 다루는 코드가 있는지 검사를 수행한다.
- 이 검증은 **보안**과 **안정성**을 보장하기 위한 단계이다.

#### 준비 (Preparation)
- **준비(Preparation)** 단계에서는 **클래스의 static 변수**들이 기본값으로 초기화 되는 단계이다.
- 자바에서는 **클래스 변수**(static 변수)가 클래스가 로드될 때 메모리 상에 할당되고, 이 때 **기본값**을 자동으로 할당한다.
    - 예를 들어, **정수형 변수**는 `0`, **부동소수형 변수**는 `0.0`, **객체 참조**는 `null`로 초기화 된다.
- 중요한 점은 이 단계에서 **실제 값**이 할당되는 것이 아니라, **기본값**만 할당된다는 것이다. 즉 클래스 로딩 시 메모리에서 **static 변수**를 사용할 준비가 되지만, 실제 값은 **초기화(Initialization)** 단계에서 할당된다.

```java
public class MyClass {
    static int x; // 기본값: 0
    static boolean flag; // 기본값: false
}
```

#### 해결 (Resolution)
- **해결(Resolution)** 단계에서는 **심볼릭 레퍼런스**를 **실제 레퍼런스**로 바꾸는 과정이다.
- 자바 클래스 파일에는 메서드, 클래스, 변수 등의 심볼릭 이름이 **심볼릭 레퍼런스**로 저장되어 있다.
- 이 심볼릭 이름은 실제 실행될 때 JVM이 해당 메서드나 클래스 등을 찾을 수 있게 해준다.
- **심볼릭 레퍼런스**는 **실제 메모리 주소**나 **메서드 참조**와 같은 **실제 실행 정보**가 아니라, **이름**으로만 기록 된다.
- 이 심볼릭 레퍼런스를 실제 참조 값으로 바꾸는 과정이 **해결(Resolution)** 이다. 예를 들어, 클래스나 메서드 호출이 실제 메모리 위치로 변환되는 과정이다.


```java
public class MyClass {
    static int x = 10;
    static void myMethod() { 
        System.out.println("Hello World");
    }
}

// 심볼릭 레퍼런스에서 실제 레퍼런스로 변환
MyClass.myMethod(); // myMethod는 심볼릭 이름으로 저장되어 있다가 실제 메모리 주소로 변환되어 호출된다
```

### 초기화 (Initialization)
- **초기화(Initialization)** 단계는 클래스가 로드된 후, 실제로 **static 변수**와 **static 초기화 블럭**이 실행되는 단계다.
- **static 초기화 블럭**(`static {}`)은 클래스가 처음 로드될 때 한번만 실행되며, 그 안에 있는 코드는 **static 변수**들을 **명시적으로 초기화**하거나, 복잡한 초기화 로직을 수행할 수 있다.

```java
public class MyClass {
    static int x; // 기본값: 0
    
    static {
        x = 10; // static 초기화 블럭에서 x 값을 10으로 설정
    }
}
```
- **초기화** 단계는 `static` 변수를 명시적으로 값을 할당하거나, 클래스가 첫 사용될 때 필요에 따라 복잡한 로직을 처리하는데 사용된다.


### ClassLoader 계층 구조

ClassLoader는 부모-자식 구조로 위임하는 **Parent Delegation Model**을 따름

```text
[Bootstrap ClassLoader]
      ↑
[Extension ClassLoader]
      ↑
[Application ClassLoader]
      ↑
[User-defined ClassLoader (ex. Tomcat, OSGi)]
```


### ClassLoader 종류 비교

| Loader 종류                   | 설명                     | 로딩 경로                                      | 구현                      |
| --------------------------- | ---------------------- | ------------------------------------------ | ----------------------- |
| **Bootstrap ClassLoader**   | JVM 내장 로더              | `JAVA_HOME/lib/` (`rt.jar`, `java.base`)   | C/C++로 구현 (Java로 접근 불가) |
| **Extension ClassLoader**   | 확장 클래스 로더              | `JAVA_HOME/lib/ext/`                       | Java                    |
| **Application ClassLoader** | 우리가 만든 클래스 로더 (일반 클래스) | `classpath` 환경변수에 지정된 경로 (`src/main/java`) | Java                    |

> `ClassLoader.getSystemClassLoader()` -> ApplicationClassLoader 반환


### Bootstrap ClassLoader

- **JVM이 가장 먼저 사용하는 로더**
- Java로 구현된 게 아니라, **JVM 내부(native)로 존재함**
- `java.lnag.*`, `java.util.*`**등 핵심 클래스 로딩**
- Java 코드로 직접 접근 불가능
    - `MyClass.class.getClassLoader()`를 하면 `null`이 뜸 (Bootstrap 이기 때문)

```java
System.out.println(String.class.getClassLoader()); // null
```

### Extension ClassLoader
- JDK의 `lib/ext` 디렉토리 또는 `java.ext.dirs` 시스템 프로퍼티로 지정된 경로
- Java로 구현되어 있고, Bootstrap의 자식
- `java.crypto`, `javax.comm` 같은 확장 패키지를 로딩
- Java 9부터는 deprecated (모듈 시스템으로 대체)

### Application ClassLoader
- 우리가 만든 클래스들은 대부분 여기서 로딩됨
- `classpath`에 지정된 디렉토리(`target/classes`, `src/main/java`)나 JAR에서 로딩
- 가장 많이 접하게 되는 ClassLoader

```java
System.out.println(MyApp.class.getClassLoader()); // sun.misc.Launcher$AppClassLoader
```

## Runtime Data Area

JVM이 자바 애플리케이션을 실행하기 위해 사용하는 **메모리 구조.**  
자바 프로그램 실행 시 JVM은 이 영역들을 스레드별 / 공용으로 나눠서 운영함

### 구성 요약

| 메모리 영역              | 설명                   | GC 대상                          | 스레드 |
| ------------------- | -------------------- |--------------------------------| --- |
| Method Area         | 클래스 메타데이터, static 변수 | X (Java8 이전 PermGen은 GC 대상 아님) | 공유  |
| Heap                | 객체 인스턴스 저장           | GC 대상                          | 공유  |
| Stack               | 스레드별 메서드 호출 정보       | X                              | 개별  |
| PC Register         | 현재 실행 중인 명령어 주소      | X                              | 개별  |
| Native Method Stack | JNI 호출 시 사용          | X                              | 개별  |

### 운영체제 관점에서 보는 메모리 구조 (프로세스 주소 공간)

```text
높은 주소
┌──────────────────────┐
│       Stack          │ ← 함수 호출 스택, 지역 변수, 매개변수
│     (Thread 별)       │
├──────────────────────┤
│       Heap           │ ← new 로 생성된 객체 (GC 대상)
│     (JVM 공유 영역)   │
├──────────────────────┤
│       Data 영역      │ ← static, 전역 변수 저장
│   (초기화 여부로 분리됨)│
├──────────────────────┤
│       Text 영역      │ ← 클래스 바이트코드 → 기계어 (실행 코드)
낮은 주소
```

```text
[OS 메모리 구조]                [JVM 내부 메모리 구조]
───────────────               ─────────────────────
Text                          → Method Area (코드, static 등)
Data Segment (C static)       → (JVM엔 없음)
Heap                          → Heap (new 객체)
Stack                         → Java Stack (Thread 별)
```

### Heap

- `new` 연산자로 생성된 **객체 인스턴스**들이 저장되는 영역
- GC(가비지 컬렉션)의 **주요 대상**
- Java 8 기준으로 **PermGen 제거**, 클래스 메타 정보는 Metaspace로 이동

#### 구조 (Hotspot 기준)

- **Young Generation**
    - Eden (객체 처음 생성)
    - Survivor S0, S1 (한번 GC 통과한 객체 이동)
- **Old Generation**
    - 생존 횟수를 넘긴 객체들이 이동 (tenuring)

### Method Area (메서드 영역)

- **클래스의 메타 정보**, static 변수, final constant, method 코드 저장
- Java 8 이전까지는 PermGen 영역
- Java 8 이후부터는 OS의 native 메모리를 사용하는 **Metaspace**로 변경됨.

#### 저장되는 정보 예시

- 클래스 이름, 상속 계층 정보
- static 변수
- method 정보 (정의, 시그니처, 바이트코드 등)

### Java Stack (스레드별 스택)

- **각 스레드마다 하나씩 생성됨**
- 메서드 호출 시마다 **Stack Frame**이 쌓임
- **지역 변수, 매개변수, 리넡 주소, 연산 중간 결과** 등 저장

```java
public void example(int x) {
    int a = 10;
    String s = "hello";
}
```
위 코드 실행 시
- `x`, `a`, `s`는 스택에 저장됨
- 단, `s`가 가리키는 "hello" 객체는 힙에 저장됨


#### Stack Frame 구성

| 구성 요소                | 설명                 |
| -------------------- | ------------------ |
| Local Variable Array | 지역 변수, 매개변수 저장     |
| Operand Stack        | 계산 중간값 저장          |
| Frame Data           | 리턴 주소, 예외 핸들링 정보 등 |


### PC Register (Program Counter)

- 현재 **JVM 명령어**가 어느 부분을 실행 중인지 나타내는 **주소 저장소**
- **각 스레드마다 하나씩 존재**

#### 특징

- JVM은 **멀티스레드** 기반이므로, 각 스레드가 독립적으로 실행 위치를 관리해야함
- **native method 실행 시에는 undefined 상태**

### Native Method Stack

- `JNI`(Java Native Interface) 기반으로 C, C++ 등 native 코드 실행 시 필요한 스택
- 일반 Java 코드의 Stack과 별개

### 전체 구조 예시 (Thread 기준)

```text
[Thread A] → Java Stack A, PC A, Native Stack A
[Thread B] → Java Stack B, PC B, Native Stack B
[공용 영역] → Heap, Method Area
```

## Execution Engine (실행 엔진)

Execution Engine은 **Runtime Data Area에 로딩된 클래스 바이트코드(.class)를 실제 기계어로 해석하고 실행하는 컴포넌트다.**  
JVM이 Java 바이트코드를 실제 CPU 명령어로 변환해서 실행하는 핵심 역할을 한다.

### Execution Engine의 구성 요소 

| 구성 요소                                | 설명                                 |
| ------------------------------------ | ---------------------------------- |
| **인터프리터 (Interpreter)**              | 바이트코드를 한 줄씩 읽고 즉시 해석해서 실행          |
| **JIT 컴파일러 (Just-In-Time Compiler)** | 자주 실행되는 바이트코드를 네이티브 코드로 변환하여 성능 향상 |
| **GC (Garbage Collector)**           | 힙 메모리에서 더 이상 사용되지 않는 객체를 자동으로 제거   |


### 인터프리터 (Interpreter)
- 바이트코드를 **한 줄씩 해석하면서 즉시 실행**
- 빠른 시작 속도를 보장하지만, **실행 속도는 느림**
- 단점: 반복되는 코드가 있을 때마다 매번 해석 -> **비효율적**

그래서 성능 향상을 위해 JIT 컴파일러와 함께 사용됨

### JIT 컴파일러 (Just-In-Time Compiler)
- 특정 메서드가 **자주 실행되면(HotSpot)** 해당 바이트코드를 **한 번에 네이티브 코드로 컴파일**
- 이후엔 **기계어 수준에서 직접 실행되므로 빠름**
- 단점: 초기에는 컴파일 시간이 필요하여 지연 발생 가능

#### JIT 동작 흐름
- 바이트코드를 인터프리터가 실행함
- HotSpot 탐지 -> 반복적으로 실행되는 코드 식별
- JIT 컴파일 -> 네이티브 코드로 변환
- 이후 해당 코드는 빠르게 실행됨

### Garbage Collector (GC)
- 힙(Heap)에 있는 **더 이상 사용되지 않는 객체를 탐지하여 메모리에서 제거**
- JVM 내에서 메모리 관리를 자동으로 처리
- 다양한 GC 방식 존재

#### 주요 GC 알고리즘 (HotSpot 기준)
| 이름                              | 특징                                  |
| ------------------------------- | ----------------------------------- |
| **Serial GC**                   | 단일 스레드로 GC 수행. 작은 애플리케이션에 적합        |
| **Parallel GC**                 | 멀티 스레드로 GC 수행. Throughput 우선        |
| **CMS (Concurrent Mark Sweep)** | GC 중 애플리케이션 중단 최소화. 일부 병렬 처리        |
| **G1GC**                        | Region 단위로 메모리 나눠 관리. Java 9+에서 기본  |
| **ZGC, Shenandoah**             | 지연시간(Latency) 극소화. Java 11+에서 선택 가능 |

### Execution Engine의 작동 요약

```text
[클래스 로더] → 바이트코드 로딩 (.class)
    ↓
[Runtime Data Area] → 메모리 구조에 적재
    ↓
[Execution Engine]
    ├─ Interpreter → 바로 해석해서 실행
    ├─ JIT Compiler → 자주 쓰는 코드 네이티브로 변환
    └─ GC → 메모리 관리 (Heap 대상)
```