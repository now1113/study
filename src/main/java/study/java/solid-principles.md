# SOLID 원칙

## 개요
> **SOLID**는 객체지향 설계를 더 **유연하고 유지보수 하기 쉬운 구조**로 만들기 위한  
> 다섯가지 핵심 원칙의 약자다.

| 약어 | 원칙명                                 | 설명          |
| -- | ----------------------------------- | ----------- |
| S  | **Single Responsibility Principle** | 단일 책임 원칙    |
| O  | **Open/Closed Principle**           | 개방-폐쇄 원칙    |
| L  | **Liskov Substitution Principle**   | 리스코프 치환 원칙  |
| I  | **Interface Segregation Principle** | 인터페이스 분리 원칙 |
| D  | **Dependency Inversion Principle**  | 의존 역전 원칙    |

## 1. SRP - 단일 책임 원칙
> "클래스는 단 하나의 책임만 가져야 한다"

### 위반 예

```java
public class ReportPrinter {
    
    public String createReport() {
        return "report";
    }

    public void printToConsole(String report) {
        System.out.println(report);
    }

    public void saveTolFile(String report) {
        // save
    } 
}
```
> 보고서 생성 + 출력 + 저장 -> 책임이 너무 많음

### 개선

```java
public class ReportCreator { String createReport() { ... } }
public class ReportSaver { void save(String report) { ... } }
public class ReportPrinter { void print(String report) { ... } }
```
> 각 클래스가 **하나의 이유로만 변경됨**


## 2. OCP - 개방-폐쇠 원칙
> "확장에는 열려 있고, 변경에는 닫혀 있어야 한다"


### 위반 예

```java
public class DiscountService {
    public int discount(String type, int price) {
        if (type.equals("fix")) {
            return price - 1000;
        } else if (type.equals("rate")) {
            return price * 90 / 100;
        }
        return price;
    }
}
```
> 정책 추가 시 if-else 수정 -> OCP 위반

### 개선: 전략 패턴

```java
public interface DiscountPolicy {
    int discount(int price);
}

public class FixDiscountPolicy implements DiscountPolicy { ... }
public class RateDiscountPolicy implements DiscountPolicy { ... }

public class DiscountPolicyFactory {
    public static DiscountPolicy getInstance(String type) {
        return switch (type) {
            case "fix" -> new FixDiscountPolicy();
            case "rate" -> new RateDiscountPolicy();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}

public class DiscountService {
    public int discount(String type, int price) {
        DiscountPolicy policy = DiscountPolicyFactory.getInstance(type);
        return policy.discount(price);
    }
}
```
> 새로운 정책 추가는 `class`만 만들면 됨 -> **기존 코드 변경 없음**

## 3. LSP - 리스코프 치환 원칙
> "자식 클래스는 부모 클래스의 자리를 대체해도 문제 없어야 한다"

### 위반 예

```java
public class Rectangle {

    void setWidth(int width) {
    }
    void setHeight(int height) {
    }
}

public class Square extends Rectangle{
    @Override
    void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}
```
> `Rectangle r = new Square(); r.setWidth(5); r.setHeight(10);` -> 면적이 기대와 다름

### 개선
- `Rectangle`과 `Square`를 별도의 `Shape`로 추상화
- **IS-A가 아닌 HAS-A 관계로 전환 고려**

## 4.ISP - 인터페이스 분리 원칙
> "클라이언트는 자신이 사용하지 않는 메서드에 의존하지 않아야 한다"

### 위반 예
```java
interface Machine {
    void print();
    void scan();
    void fax();
}

class OldPrinter implements Machine {
    public void print() { ... }
    public void scan() { ... }
    public void fax() { ... }
}
```

### 개선
```java
interface Printer { void print(); }
interface Scanner { void scan(); }

class OldPrinter implements Printer { ... }
```
> 역할별로 인터페이스 분리 -> 필요한 기능만 구현


## 5. DIP - 의존 역전 원칙
> "상위 모듈은 하위 모듈에 의존하면 안 된다.  
> 추상화에 의존해야 한다."

### 위반 예
```java
public class OrderService {
    private final MySqlOrderRepository repo = new MySqlOrderRepository();
}
```
> 구체 구현에 직접 의존 -> 확장 어려움

### 개선
```java
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
```
> 의존성 주입(DI)을 통해 추상화에만 의존