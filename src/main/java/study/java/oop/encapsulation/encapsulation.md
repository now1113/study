# Encapsulation

**캡슐화 (Encapsulation)** - 객체지향의 첫 번째 본질

## 정의
> **캡슐화란?**  
> 객체의 **상태(데이터)와 행위(메서드)를 하나로 묶고**,  
> **데이터에 직접 접근을 차단**하여 무결성을 유지하는 개념이다.

- 필드는 `private`
- 접근은 메서드를 통해 (`getter`, `setter`, 의미 있는 도메인 메서드)

## 왜 캡슐화가 중요한가?
| 이유             | 설명                            |
| -------------- | ----------------------------- |
| **데이터 보호**     | 외부가 객체 내부 상태를 함부로 바꾸지 못하게 보호  |
| **유지보수 용이**    | 내부 구현을 변경해도 외부 코드를 수정할 필요 없음  |
| **유효성 보장**     | 상태 변경 시 유효성 검사를 강제할 수 있음      |
| **도메인 규칙 내재화** | 객체가 자신의 상태와 규칙을 책임지도록 만들 수 있음 |

## 예제

### 1. 캡슐화 적용

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
- 필드 직접 접근 불가 (`user.name = "kim"` 불가능)
- `changeName` 메서드를 통해 유효성 검증 포함
- **의미 있는 메서드 이름으로 도메인 행위 표현** (`setName` 대신 `changeName`)

### 2. 잘못된 예: setter 남용

```java
public class Product {
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }
}
```
```java
product.setPrice(-100); // 음수 가격?
```
- 상태 변경에 **아무런 제약이 없음**
- 이런 구조에서는 어디서, 왜 깨졌는지 추적 어려움
- **불변성 및 도메인 규칙을 전혀 지킬 수 없음**

### 3. 의미 있는 도메인 메서드로 대체하기

```java
public class Product {
    private int price;
    
    public void increasePrice(int delta) {
        if (delta < 0) throw new IllegalArgumentException("가격 증가량은 0 이상이어야 합니다.");
        this.price += delta;
    }
}
```
- `setPrice` -> X
- `increasePrice`, `applyDiscount`, `updatePriceByPolicy` 등으로 의미를 명확히 표현

###  4. 회원 등급 시나리오

#### 요구사항
- 사용자는 `Basic`, `Premium`, `Vip` 중 하나의 등급을 가진다.
- 등급은 등급 조건(누적 구매 금액 등)을 만족할 때만 승격 가능하다.
- 등급을 직접 변경하는건 불가능하다.

#### 잘못된 구조 (setter 남용)

```java
public class Member {
    private String name;
    private String grade;

    // Premium이든 Vip든 누가나 막 바꿀 수 있음
    public void setGrade(String grade) {
        this.grade = grade; 
    }
}
```
- 외부에서 `member.setGrade("vip")`와 같이 등급을 **아무 조건 없이 막 바꿀 수 있음**
- **도메인 규칙이 객체 바깥에서 흩어짐**

#### 캡슐화 + 도메인 규칙 포함한 구조

```java
public class Member {
    private final String name;
    private Grade grade;
    private int totalPurchaseAmount;

    public Member(String name, Grade grade, int totalPurchaseAmount) {
        this.name = name;
        this.grade = grade;
        this.totalPurchaseAmount = totalPurchaseAmount;
    }
    
    public void addPurchaseAmount(int purchaseAmount) {
        this.totalPurchaseAmount += purchaseAmount;
        // 내부에서 등급 조건 확인
        evaluateGrade();
    }
    
    private void evaluateGrade() {
        if (this.totalPurchaseAmount > 1_000_000) {
            this.grade = Grade.Vip;
        } else if (this.totalPurchaseAmount > 500_000) {
            this.grade = Grade.Premium;
        } else {
            this.grade = Grade.Basic;
        }
    }

    public Grade getGrade() {
        return grade;
    }
}
```
```java
public enum Grade {
    Basic, Premium, Vip
}
```
- 등급 변경은 외부에서 불가능 -> **도메인 내부로만 캡슐화**
- `addPurchase()`는 의미 있는 도메인 메서드
- 등급 정책을 `evaluateGrade()`로 숨김 -> 변경 시 한 곳만 수정
- **객체가 자기 상태와 규칙을 책임지는 도메인 모델**

#### 이 구조의 장점
| 장점                 | 설명                                              |
| ------------------ | ----------------------------------------------- |
|  **규칙 변경에 유연**   | 정책 바뀌면 `evaluateGrade()`만 수정하면 됨                |
|  **깨진 객체 상태 방지** | 외부에서 직접 `grade` 변경 불가                           |
|  **협력 객체에도 안정적** | 도메인 계약이 객체 안에 보장되어 있기에 다른 도메인 서비스에서도 안심하고 사용 가능 |
|  **테스트 쉬움**      | `addPurchase()` 호출 후 등급만 검사하면 테스트 OK            |


## 자주 하는 실수
| 실수                           | 문제점                             |
| ---------------------------- | ------------------------------- |
| 모든 필드에 `getter/setter` 자동 생성 | 객체가 단순 DTO가 되어 도메인 규칙이 사라짐      |
| `public` 필드로 노출              | 외부가 직접 상태를 제어하여 불변성, 일관성 깨짐     |
| 의미 없는 `get/set` 메서드          | 외부가 상태를 컨트롤하게 되어 객체가 수동적인 구조가 됨 |

## 캡슐화 설계 팁
| 상황                 | 팁                                                                          |
| ------------------ | -------------------------------------------------------------------------- |
| 값 변경이 필요한 필드       | `setXxx` 대신 `changeXxx`, `increaseXxx`, `disableXxx` 등 **의도 있는 메서드 이름 사용** |
| 변경 불필요한 필드         | 아예 `getter`도 만들지 말거나, **생성자 주입 + final 필드 사용**                             |
| 계층 분리된 구조에서 DTO 필요 | DTO는 `getter/setter` 써도 OK (순수 데이터 전달 목적)                                  |
| 도메인 객체는            | `private` 필드 + **도메인 행위 중심의 메서드만 열기**                                      |


## 포인트

> Q. 자바에서 캡슐화란 무엇인가요?
- 객체의 상태를 외부로부터 숨기고, 메서드를 통해서만 조작하게 하여 **무결성과 안정성을 보장하는 설계 원칙**
- 필드를 `private`으로 숨기고, 상태 변경 시 **도메인 규칙을 강제하는 의미 있는 메서드**를 사용해야 진정한 캡슐화가 이루어짐.