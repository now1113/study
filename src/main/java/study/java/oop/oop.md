# OOP(Object-Oriented Programming)

## 핵심 개념
OOP는 **데이터와 행동(메서드)을 객체로 묶어 추상화**하고, 프로그램을 객체들의 상호작용으로 구성하는 패러다임이다.  
Java는 **순수 OOP는 아니지만**, 대부분의 OOP 개념을 지원한다.

### 자바에서의 4가지 핵심 특성
| 특성                     | 설명                                               | Java 적용 예                         |
| ---------------------- | ------------------------------------------------ | --------------------------------- |
| **캡슐화(Encapsulation)** | 내부 상태를 외부에서 직접 접근하지 못하게 막고, 메서드를 통해서만 접근하도록 하는 것 | private 필드 + public getter/setter |
| **상속(Inheritance)**    | 기존 클래스의 기능을 물려받고, 확장하거나 재정의할 수 있게 하는 것           | `extends`, `super` 키워드            |
| **다형성(Polymorphism)**  | 동일한 메시지를 다양한 방식으로 처리할 수 있도록 하는 것                 | 메서드 오버라이딩, 인터페이스                  |
| **추상화(Abstraction)**   | 복잡한 로직은 숨기고, 필요한 정보만 제공하는 것                      | 인터페이스, 추상 클래스                     |

## 캡슐화

```java
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = newName;
    }
}
```
- 외부에서 직접 `user.name = "kim"`을 못하게 하고,
- 반드시 유효성 검사를 거처야 바뀌도록 만든 구조


## 상속과 Liskov 치환 원칙
```java
class Animal {
    void speak() { System.out.println("..."); }
}
class Dog extends Animal {
    void speak() { System.out.println("dog!"); }
}
```
- `Aniaml animal = new Dog();`으로도 정상 동작함 -> 부모 클래스(`Animal`)의 역할을 자식 클래스(`Dog`)가 자연스럽게 수행
- 이것이 바로 **Liskov Substitution Principle(LSP)** 만족 예시

### 잘못된 예시: LSP 위반
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

- Square는 Rectangle 자리에 들어갔지만 **동작이 달라짐**
- `Rectangle`은 "가로와 세로를 독립적으로 설정할 수 있는 도형"이라는 **계약**이 있는데, `Square`는 그걸 깨버림
- **이것이 바로 LSP 위반**


## 다형성과 인터페이스 기반 설계
```java
interface PaymentGateway {
    void pay(int amount);
}
class KakaoPay implements PaymentGateway {
    @Override
    public void pay(int amount) {
        System.out.println("카카오페이 결제: " + amount);
    }
}
class NaverPay implements PaymentGateway {
    @Override
    public void pay(int amount) {
        System.out.println("네이버페이 결제:" + amount);
    }
}
```
- `List<PaymentGateway>`형태로 다양한 구현체를 다형성으로 처리 가능

## 추상화
```java
abstract class Shape {
    abstract double area();
}
class Circle extends Shape {
    double radius;
    Circle(double r) { this.radius = r; }
    double area() { return Math.PI * radius * radius; }
}
```
- 추상 메서드로 **구현을 강제**하면서도 인터페이스처럼 사용 가능


## 주의 사항

| 실수                      | 설명                                                      |
| ----------------------- | ------------------------------------------------------- |
| 모든 필드에 getter/setter 남발 | 캡슐화 깨짐 → 불변성 지키기 어렵고 도메인 규칙 숨김                          |
| 상속으로 코드 재사용만 노림         | IS-A 관계가 아니면 상속보다 조합이 나음 (Composition over Inheritance) |
| 추상화 수준이 명확하지 않음         | `Manager`, `Processor` 같은 이름만 바꾸는 클래스는 진짜 추상화 아님        |
| 다형성 무시하고 instanceof 사용  | 인터페이스 설계를 제대로 안 한 결과일 가능성                               |
