# Abstraction (추상화)

## 추상화란
> 추상화(Abstraction)는  
> **복잡한 내부 구현은 숨기고,**  
> **필요한 정보나 동작만 외부에 제공**하는 객체지향 설계 원칙이다.

- 객체가 수행할 **기능(행위)에만 집중**하게 함
- **구현 세부사항은 감추고, 역할 중심의 인터페이스만 제공**
- 자바에서는 `interface` 또는 `abstract class`를 통해 실현된다

## 추상화의 목적
| 목적              | 설명                                     |
| --------------- | -------------------------------------- |
| **복잡성 은닉**      | 내부 구조/구현은 감추고 사용자는 "무엇을 할 수 있는지"만 알면 됨 |
| **유지보수 용이**     | 구현 변경 시 외부 영향 없음 (계약만 지키면 됨)           |
| **다형성 기반 제공**   | 다양한 구현체를 동일한 추상 타입으로 다룰 수 있음           |
| **역할 기반 설계 가능** | 객체의 “역할”에 집중 → 책임 분리 용이                |

## 추상화 예제

### 인터페이스 기만 추상화
```java
public interface RemoteControl {
    void turnOn();
    void turnOff();
}
```
- TV든 에어컨이든 상관 없이 "켜고 끄는" **기능만 추상화**
- 구현은 다르지만 **동일한 인터페이스로 사용 가능**

```java
public class TV implements RemoteControl {
    public void turnOn() { System.out.println("TV ON"); }
    public void turnOff() { System.out.println("TV OFF"); }
}

public class AirConditioner implements RemoteControl {
    public void turnOn() { System.out.println("AC ON"); }
    public void turnOff() { System.out.println("AC OFF"); }
}
```

## interface / abstract class 차이
| 구분     | interface               | abstract class   |
| ------ | ----------------------- | ---------------- |
| 다중 상속  | 가능 (여러 개 구현 가능)         | 불가 (단일 상속만)      |
| 필드/상태  | 선언 불가 (Java 8까지)        | 필드 가짐            |
| 생성자    | 없음                      | 생성자 있음           |
| 디폴트 구현 | Java 8부터 default 메서드 허용 | 일반 메서드 사용 가능     |
| 용도     | 역할 중심 설계                | 기본 로직 포함한 공통 추상화 |

- **순수 역할(계약)만 정의**하고 싶을 땐 -> `interface`
- **공통 구현 + 확장 지점 제공**하고 싶을 땐 -> `abstract class`

## 잘못된 추상화의 예

### 이름만 추상화된 인터페이스

```java
public interface UserManager {
    void process();
}
public class UserMangerImpl implements UserManager{
    @Override
    public void process() {
        // 인증, 결제 등 복합적인 로직 존재
    }
}
```
> 이름은 `UserManager`인데 구현이 뒤죽박죽 -> **역할 분리가 제대로 되지 않음**

### 개선: 역할 기반 추상화
```java
public interface Authenticator {
    void authenticate(User user);
}
public interface Authorizer {
    void authorize(User user, Resource resource);
}
```
> **관심사 단위로 분리된 추상화** -> 역할 명확, 협력 명확, 테스트 쉬움


## 설계에서의 추상화
| 상황                             | 추상화 전략                                              |
| ------------------------------ | --------------------------------------------------- |
| 다양한 구현체를 유연하게 다루고 싶다           | `interface`로 역할 추상화                                 |
| 기본 로직은 공통으로 제공하고 일부만 다르게 하고 싶다 | `abstract class`로 기본 제공 + 템플릿 메서드 패턴                |
| 클라이언트가 역할만 의존해야 한다             | 의존성 역전(DIP) 원칙 + interface                          |
| 이름이 애매한 인터페이스                  | 실제 책임에 맞게 `UserRepository`, `MessageSender` 등으로 명확화 |


## 결론

> 추상화란 무엇인가
- 내부 구현을 감추고 객체의 본질적인 동작만 외부에 공개하는 설계 원칙
- Java에서는 `interface` 또는 `abstract class`로 표현되며, 다형성을 활용하기 위한 기반이 된다.

> interface와 abstract class의 차이점
- `interface`는 순수 역할을 정의하고, `abstract class`는 공통 로직 일부 제공하면서 확장을 허용한다
- 일반적으로 `역할 설계`에는 인터페이스, `기본 로직 + 확장 포인트`는 추상 클래스를 사용한다.