# Polymorphism (다형성)

## 다형성이란
> 다형성은  
> **동일한 메세지(메서드 호출)** 에 대해  
> **다양한 형태**로 동작할 수 있게 하는 객체지향 개념이다.

즉, 하나의 타입(인터페이스/부모 클래스)으로 여러 구현체를 유연하게 다룰 수 있게 한다.

## 자바에서 다형성의 형태
| 형태              | 설명                        | 예시                              |
| --------------- | ------------------------- | ------------------------------- |
| **상속 기반 오버라이딩** | 부모 클래스의 메서드를 자식이 재정의      | `@Override`                     |
| **인터페이스 기반 구현** | 하나의 인터페이스에 여러 구현체         | `implements`                    |
| **동적 바인딩**      | 실행 시점에 실제 메서드가 결정됨        | `Animal animal = new Dog();`    |
| **메서드 오버로딩**    | 같은 이름, 다른 파라미터로 여러 메서드 정의 | `print(String)`, `print(int)` 등 |

## 기본 예제

```java
interface PaymentGateway {
    void pay(int amount);
}

class KakaoPay implements PaymentGateway {
    public void pay(int amount) {
        System.out.println("카카오페이 결제: " + amount);
    }
}

class NaverPay implements PaymentGateway {
    public void pay(int amount) {
        System.out.println("네이버페이 결제: " + amount);
    }
}
```
```java
public void processPayment(PaymentGateway gateway) {
    gateway.pay(10000);
}
```

## 다형성 예시

### 전략 패턴 (Strategy Pattern)

```java
public interface DiscountPolicy {
    int discount(int price);
}

public class FixDiscountPolicy implements DiscountPolicy {
    public int discount(int price) { return 1000; }
}

public class RateDiscountPolicy implements DiscountPolicy {
    public int discount(int price) { return price * 10 / 100; }
}
```
```java
public class OrderService {
    private final DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public int finalPrice(int price) {
        return price - discountPolicy.discount(price);
    }
}
```
- `OrderService`는 어떤 `DiscountPolicy`든 사용할 수 있음 -> 확장에 열려 있고 변경에 닫힘 (**OCP 원칙**)
- 실제 구현체는 **DI(의존성 주입)** 으로 주입

## 다형성이 개지는 경우
| 실수                 | 문제점                               |
| ------------------ | --------------------------------- |
| `instanceof` 남용    | 다형성을 무시하고 타입에 따라 조건 분기            |
| switch로 구현 분기      | OOP가 아니라 절차지향 방식                  |
| 인터페이스 없이 구체 클래스 사용 | 유연성이 떨어짐, 테스트 어려움                 |
| 타입 캐스팅             | 부모 → 자식 다운캐스팅 → 예외 위험, LSP 위반 가능성 |

### 예시: 다형성을 지키지 않은 코드
```java
if (paymentType.equals("kakao")) {
    new KakaoPay().pay(10000);
} else if (paymentType.equals("naver")) {
    new NaverPay().pay(10000);
}
```

### 개선: 다형성 적용
```java
Map<String, PaymentGateway> paymentMap = Map.of(
    "kakao", new KakaoPay(),
    "naver", new NaverPay()
);
paymentMap.get(paymentType).pay(10000);
```

## 다형성의 이점

| 이점              | 설명                                 |
| --------------- | ---------------------------------- |
| **확장성**         | 새로운 구현체를 추가해도 기존 코드는 손대지 않음        |
| **유지보수성**       | 구현체 내부가 바뀌어도 클라이언트 영향 없음           |
| **테스트 용이성**     | 인터페이스만 알면 mock/test double로 테스트 가능 |
| **SOLID 원칙 준수** | OCP, DIP 실천의 기반                    |

## 설계할 때 고려사항
| 상황             | 팁                                         |
| -------------- | ----------------------------------------- |
| 여러 구현이 있는 경우   | 반드시 인터페이스로 추상화                            |
| 전략이 바뀔 수 있는 경우 | Strategy, State 패턴 활용                     |
| 런타임에 구현 선택     | `Map<String, Impl>` 등록 후 DI 또는 Factory 사용 |
| 테스트할 때         | mock 인터페이스 주입으로 유닛 테스트 가능                 |


## 요약

> 자바에서 다형성이란
- 동일한 인터페이스(혹은 부모 클래스)를 통해 여러 구현체를 처리할 수 있게 하는 객체지향의 핵심 개념
- 실행 시점에 실제 메서드가 결정되는 **동적 바인딩**도 다형성의 일환

> 다형성이 중요한 이유
- 구현체의 변경이나 확장에 유연하게 대응할 수 있으며, OCP 원칙을 지킬 수 있어 **유지보수성과 테스트 용이성이 극대화**된다.

