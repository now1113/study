## 트랜잭션

- **데이터베이스의 상태를 변화시키는 하나의 논리적인 작업 단위**
- 논리적인 작업의 쿼리 개수와 상관 없이 논리적인 작업 셋 자체가 100% 적용되거나 아무것도 적용되지 않아야 함을 보장

### ACID

- **Atomicity**(원자성)
  - 트랜잭션을 구성하는 연산 전체가 모두 정상적으로 실행되거나 모두 취소되어야 한다.
- **Consistency**(일관성)
  - 트랜잭션이 실행을 성공적으로 완료하면 언제나 일관성 있는 데이터베이스 상태로 유지한다.
- **Isolation**(고립성)
  - 두 개 이상의 트랜잭션이 동시에 발생할 때, 서로의 연산에 영향을 주면 안된다.
- **Durability**(영구성)
  - 커밋된 트랜잭션의 내용은 영구히 반영된다.

### 트랜잭션 격리수준

| 수준                   | 특징                                                           |
| -------------------- | ------------------------------------------------------------ |
| **Read Uncommitted** | 커밋되지 않은 데이터를 읽을 수 있음 → **Dirty Read** 발생 가능                  |
| **Read Committed**   | 커밋된 데이터만 읽음 → **Non-repeatable Read** 발생 가능                  |
| **Repeatable Read**  | 트랜잭션 내에서 같은 조건의 SELECT는 항상 같은 결과 보장 → **Phantom Read** 발생 가능 |
| **Serializable**     | 가장 높은 수준의 고립 → 다른 트랜잭션이 데이터에 접근 불가, 성능 저하 가능                 |

## 이상현상

### Dirty Read

다른 트랜잭션에서 아직 **커밋되지 않은 변경 사항**을 읽어오는 현상

발생조건: `Read Uncommitted` 수준에서만 발생

#### 예제 시나리오

| 트랜잭션 A                                       | 트랜잭션 B                                                         |
| -------------------------------------------- | -------------------------------------------------------------- |
| -                                            | SELECT balance FROM account WHERE id = 1; → `1000원`            |
| UPDATE account SET balance = 0 WHERE id = 1; |                                                                |
| → (아직 COMMIT 안 함)                            | SELECT balance FROM account WHERE id = 1; → `0원` (**Dirty Read**) |
| ROLLBACK;                                    |                                                                |
| -                                            | 읽은 값은 실제 데이터가 아님                                               |

-> 커밋되지 않은 임시 상태를 읽었기 때문에 **롤백되면 잘못된 데이터를 사용한 것**이 됨


### Non-Repeatable Read

같은 조건으로 두 번 조회했을 때, **결과가 다르게 나오는 현상**

발생조건: `Read Committed`에서 발생

#### 예제 시나리오

| 트랜잭션 A                                                 | 트랜잭션 B                                     |
| ------------------------------------------------------ | ------------------------------------------ |
| SELECT name FROM users WHERE id = 1; → "철수"            |                                            |
| -                                                      | UPDATE users SET name = '영희' WHERE id = 1; |
| -                                                      | COMMIT;                                    |
| SELECT name FROM users WHERE id = 1; → "영희" (**값 바뀜**) |                                            |

-> 한 트랜잭션 내에서 같은 쿼리를 실행했지만 **결과가 달라짐**


### Phantom Read

같은 조건의 **범위 쿼리에서**, 처음엔 없던 데이터가 **다음에 나타나는 현상**

발생 조건: `Repeatable Read`에서는 방지 안 됨, `Serializable`에서만 완벽 방지

#### 예제 시나리오

| 트랜잭션 A                                                     | 트랜잭션 B                                    |
| ---------------------------------------------------------- | ----------------------------------------- |
| SELECT \* FROM orders WHERE amount > 100; → 3건             |                                           |
| -                                                          | INSERT INTO orders (amount) VALUES (200); |
| -                                                          | COMMIT;                                   |
| SELECT \* FROM orders WHERE amount > 100; → 4건 (**팬텀 발생**) |                                           |

SELECT * FROM orders WHERE amount > 100; -> 4건 (팬텀 발생)

처음에는 3건이었는데, **다른 트랜잭션이 데이터를 끼워넣고 커밋**하니까 같은 조건으로 다시 조회해도 **결과가 달라짐**


### 이상현상 요약

| 이상 현상               | 발생 격리 수준         | 해결 가능한 격리 수준       |
| ------------------- | ---------------- | ------------------ |
| Dirty Read          | Read Uncommitted | Read Committed 이상  |
| Non-Repeatable Read | Read Committed   | Repeatable Read 이상 |
| Phantom Read        | Repeatable Read  | Serializable       |

## MVCC란?

**MVCC**(다중 버전 동시성 제어)는 트랜잭션마다 각기 다른 데이터 스냅샷(버전)을 보면서 동시에 작업할 수 있도록 해주는 기술이다.

**핵심 원리**:

- `SELECT`는 커밋된 **과거 시점의 데이터를 읽음** > **현재 트랜잭션이 시작된 시점에 존재하던 커밋 완료 데이터만 조회된다는 의미**
- `DELETE`, `UPDATE`는 실제로 행을 즉시 지우지 않고 **숨겨진 버전 필드로 관리**
- Undo Log 기반으로 버전 정보를 유지


### MySQL의 MVCC로 막을 수 있는 것

| 이상 현상               | MVCC로 방지 가능 여부 | 설명                        |
| ------------------- | -------- | ------------------------- |
| Dirty Read          | 가능       | 커밋되지 않은 데이터는 읽지 않음        |
| Non-Repeatable Read | 가능       | 트랜잭션 시작 시점의 스냅샷을 계속 참조    |
| Phantom Read        | 불완전      | 새로운 **범위의 행이 추가되면 감지 못함** |

**MVCC는 행(Row) 수준에서만 동작**하기 때문에, 새로운 **행 자체의 출현(팬텀)은 감지할 수 없음** -> 이를 막으려면 **갭 락**이 필요함.


### Gap Lock 이란

**Gap Lock**은 인덱스 기반 범위에 대해 **존재하지 않는 값에 대해서도 락을 거는 방식**이다.

```sql
SELECT * FROM users WHERE age BETWEEN 20 AND 30 FOR UPDATE;
```

-> 이 쿼리는 20~30살까지 실제 존재하는 행뿐만 아니라 20~30 사이의 **빈 공간**(Gap)에도 락을 걸어버림

그래서 다른 트랜잭션이 그 범위에 INSERT 못하게 막음 -> **Phantom Read 방지 가능**

> InnoDB는 **Repeatable Read 수준에서 자동으로 Gap Lock을 걸어줘서 팬텀을 방지함** 단, **인덱스가 있는 경우에만 적용됨**


### 정리

| 항목                 | 내용                                              |
| ------------------ | ----------------------------------------------- |
| MVCC의 목적           | 동시성을 높이면서도 읽기 일관성(Read Consistency) 보장          |
| MVCC 방지 범위         | Dirty Read, Non-Repeatable Read                 |
| Phantom Read 방지 방법 | **Gap Lock**, **Next-Key Lock**(Gap + Row Lock) |
| 적용 조건              | InnoDB + 인덱스 기반 범위 쿼리 + REPEATABLE READ 이상      |
| SERIALIZABLE 사용 시  | 모든 SELECT가 암묵적 `LOCK IN SHARE MODE` 적용됨 → 성능 저하 |

### MySQL 격리 수준에서의 현상 정리

| 격리 수준            | Dirty Read | Non-Repeatable | Phantom Read | 설명                    |
| ---------------- |----------| ----------- | -------- | --------------------- |
| Read Uncommitted | 발생       | 발생          | 발생       | 커밋 안 된 것도 읽음          |
| Read Committed   | X        | 발생          | 발생       | 커밋된 것만 읽음             |
| Repeatable Read  | X         | X            | X         | InnoDB가 Gap Lock으로 막음 |
| Serializable     | X         | X            | X         | 락 기반으로 완전 차단          |


## 데이터베이스에서의 Lock

### Lock이란

- **여러 트랜잭션이 동시에 같은 데이터에 접근할 때, 데이터의 정합성을 보장**하기 위해 걸어주는 제어 장치
- **트랜잭션 충돌 방지**
- **Dirty Raed, Lost Update, Non-repeatable Read 방지**


### 공유 락(Shard Lock, S-Lock)

- **읽기 전용 락**
- 여러트랜잭션이 **동시에 읽을 수 있음**
- 하지만 **쓰기는 불가능**

```sql
SELECT * FROM users WHERE id = 1 LOCK IN SHARE MODE;
```

### 베타 락(Exclusive Lock, X-Lock)

- **쓰기 락**
- 해당 레코드를 **읽거나 쓰는 트랜잭션은 오직 1개만 허용**
- 다른 트랜잭션은 **읽기/쓰기 모두 대기**

```sql
SELECT * FROM users WHERE id = 1 FOR UPDATE;
```

### 락의 범위

| 범위                | 설명                                    |
| ----------------- | ------------------------------------- |
| **Row Lock**      | 특정 행에만 락을 거는 방식 (InnoDB 기본)           |
| **Table Lock**    | 테이블 전체에 락을 거는 방식 (MyISAM 기본)          |
| **Page Lock**     | DB 페이지 단위로 락을 거는 방식 (InnoDB 내부적으로 사용) |
| **Gap Lock**      | 인덱스 **사이 공간**에 락을 거는 방식               |
| **Next-Key Lock** | Gap Lock + Row Lock 조합, 팬텀 방지용        |


### 낙관적 락 vs 비관적 락

| 구분        | 설명                                                             |
| --------- | -------------------------------------------------------------- |
| **비관적 락** | 먼저 락을 걸고 다른 트랜잭션 접근을 막는 방식 (DB 기본 락 전략)                        |
| **낙관적 락** | 충돌이 거의 없다고 가정하고, 업데이트 시점에 충돌 여부를 검사<br>(ex. 버전 번호, `@Version`) |
