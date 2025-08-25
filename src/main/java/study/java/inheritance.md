# Inheritance (상속)

## 1. 상속이란
> **상속(Inheritance)은**  
> 기존 클래스의 속성과 행위를 **재사용**하고,  
> 필요한 부분은 **확장/변경(오버라이딩)** 할 수 있게 해주는 객체지향의 핵심 개념이다.

- Java에서는 `extends` 키워드로 **단일 상속만 지원**
- 공통 기능을 상위 클래스에 정의하고, 하위 클래스에서 재사용 + 확장

```java
class Animal {
    void speak() {
        System.out.println("speak");
    }
}

class Dog extends Animal {
    @Override
    void speak() {
        System.out.println("멍멍");
    }
}
```
> `Dog`는 `Aniaml`을 상속받아 `speack()` 메서드를 재정의한다  
> -> 코드 재사용 + 다형성 활용 가능


## 2. 상속의 장점과 한계

### 장점
| 항목         | 설명                       |
| ---------- | ------------------------ |
| **코드 재사용** | 중복된 코드를 줄일 수 있음          |
| **다형성 구현** | 부모 타입으로 자식 클래스 제어 가능     |
| **확장 용이성** | 부모 기능을 기반으로 새로운 기능 추가 가능 |

### 한계
| 문제점          | 설명                                  |
| ------------ | ----------------------------------- |
| **캡슐화 침해**   | 부모 클래스의 protected 필드/메서드에 과도한 의존 발생 |
| **결합도 증가**   | 부모 변경이 자식에게 영향 → **취약한 기반 클래스 문제**  |
| **단일 상속 제한** | Java는 다중 상속 미지원 → 유연한 구조가 어려움       |
| **테스트 어려움**  | 부모 의존 → 자식 테스트시 mocking 복잡          |


## 3. IS-A vs HAS-A

### IS-A 관계
>"A는 B이다" -> 상속

```java
class Animal {}
class Dog extends Animal {} // Dog IS-A Animal
```

### HAS-A 관계
> "A는 B를 가진다" -> 조합(Composition)

```java
class Engine {}
class Car {
    private Engine engine = new Engine(); // Car HAS-A Engine
}
```

### 언제 상속하고 언제 조합할까
| 상황                 | 권장 방식                                |
| ------------------ | ------------------------------------ |
| 코드 재사용 / 다형성 필요    | 상속 (IS-A)                            |
| 책임 위임 / 유연한 변경 가능성 | 조합 (HAS-A)                           |
| 상속이 비논리적이거나 강제된다면  | 조합 선호 (Composition over Inheritance) |


## 4. 잘못된 상속의 예 (LSP 위반)

### Retangle -> Square 문제

```java
class Rectangle {
    protected int width, height;

    public void setWidth(int w) { width = w; }
    public void setHeight(int h) { height = h; }

    public int getArea() { return width * height; }
}

class Square extends Rectangle {
    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w); // 가로 == 세로로 강제
    }

    @Override
    public void setHeight(int h) {
        super.setHeight(h);
        super.setWidth(h); // 세로 == 가로로 강제
    }
}
```
```java
public void printArea(Rectangle r) {
    r.setWidth(5);
    r.setHeight(10);
    System.out.println("Expected area = 50, Actual = " + r.getArea());
}
```
> printArea(new Rectangle()) -> 출력: 50  
> printArea(new Square()) -> 출력: 100  
> `Square`는 `Rectangle` 자리에 들어갈 수 있지만 동작이 달라짐  
> -> **Liskov Substitution Principle(LSP) 위반**

### 해결 방법
- `Rectangle`, `Square`를 `Shape` 인터페이스로 분리
- 각 도형은 독립적인 캡술화 구조로 정의

## 5. 상속보단 조합이 더 나은 사례

### 서비스 클래스 재사용

#### 잘못된 상속 사용

```java
class BaseService {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
}
class UserService extends BaseService {
    // logger 사용 위해 상속...
}
```

#### 조합으로 개선
```java
class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);
}
```

> 단순 필드 접근을 위해 상속 -> 오히려 캡슐화 깨짐  
> 조합이 더 유연하고 테스트/확장에 유리


## 6. 자바에서의 주의사항

| 개념                     | 설명                                       |
| ---------------------- | ---------------------------------------- |
| **super**              | 부모 메서드 호출 시 사용 (`super.method()`)        |
| **final class/method** | 더 이상 상속/오버라이딩 불가 (`String`, `Integer` 등) |
| **생성자 호출 순서**          | 자식 → 부모 → 필드 초기화 순서 주의                   |
| **protected 위험성**      | 패키지 외부에서는 오용되기 쉬움 (가시성 주의)               |


