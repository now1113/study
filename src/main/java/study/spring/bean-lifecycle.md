# Spring Bean Life Cycle (빈 생명주기)

## 1. 개요

Spring Bean 생명주기란, 객체가 **스프링 컨테이너에 의해 생성되고, 초기화되고, 사용되다가 소멸되는 전체 과정**을 말한다.  
이 과정을 전담하는 것이 바로 **스프링 컨테이너(Spring Container)** 이며, 그 핵심 구현체가 바로 `ApplicationContext`다.


## ApplicationContext

`ApplicationContext`는 **스프링 컨테이너를 대표하는 인터페이스**로,  
스프링에서 Bean을 생성하고 관리하며 의존성을 주입하는 등의 역할을 수행한다.

- `org.springframework.context.ApplicationContext`는 `BeanFactory`의 하위 인터페이스이며,
- `BeanFactory`가 제공하는 기본 DI 기능 외에도 다양한 고급 기능을 제공한다.

### ApplicationContext vs BeanFactory

| 항목              | BeanFactory               | ApplicationContext                |
|-----------------|---------------------------|------------------------------------|
| 기본 역할         | DI (의존성 주입) 컨테이너    | DI + 부가 기능 포함한 컨테이너         |
| Lazy Init       | 지원                       | 지원                                |
| 메세지 소스 처리   | 미지원                     | 지원 (국제화 가능)                    |
| 이벤트 발행       | 미지원                     | 지원 (ApplicationEventPublisher)    |
| AOP 지원         | 제한적                     | 자동 프록시 생성 가능                  |
| 사용 위치         | 경량 테스트, 리소스 제약 환경 | 대부분의 실전 환경에서 사용             |

### ApplicationContext의 주요 책임

- **Bean 등록 및 조회** (`getBean()`)
- **Bean 생명주기 관리** (생성 -> 의존성 주입 -> 초기화 -> 소멸)
- **메시지 소스 처리** (i18n 지원)
- **ApplicationEvent 발행** (Observer 패턴 기반 이벤트 처리)
- **AOP 프록시 자동 적용** (BeanPostProcessor 기반)

## ApplicationContext의 종류와 SpringBoot에서의 역할

SpringBoot에서는 애플리케이션 종류에 따라 **자동으로 알맞은** `ApplicationContext` **구현체**를 내부적으로 생성한다.  
우리가 직접 만들지 않아도 SpringBoot가 애플리케이션 실행 시점에 적절한 컨텍스트를 설정해준다.

### 애플리케이션 종류별 ApplicationContext 종류

| 애플리케이션 종류           | ApplicationContext 구현체                                | 웹서버                  |
| ------------------- | ----------------------------------------------------- | -------------------- |
| **일반 자바 애플리케이션**    | `AnnotationConfigApplicationContext`                  |  없음                  |
| **서블릿 기반 웹 애플리케이션** | `AnnotationConfigServletWebServerApplicationContext`  |  Tomcat (기본), Jetty 등 |
| **리액티브 웹 애플리케이션**   | `AnnotationConfigReactiveWebServerApplicationContext` |  Reactor Netty       |

> 스프링 부트는 **애플리케이션 타입을 자동으로 감지**하여 위 클래스 중 하나를 선택한다.

### 클래스는 어디에서 올까?

| ApplicationContext 구현체 이름                             | 소속 라이브러리                       |
| ----------------------------------------------------- | ------------------------------ |
| `AnnotationConfigApplicationContext`                  | `spring-context`               |
| `AnnotationConfigServletWebServerApplicationContext`  | `spring-boot`                  |
| `AnnotationConfigReactiveWebServerApplicationContext` | `spring-boot` (`webflux` 포함 시) |

- `spring-context`만 추가된 경우 -> 순수한 스프링 (non-boot)
- `spring-boot-starter-web` -> 서블릿 기반 웹 앱
- `spring-boot-starter-webflux` -> 리액티브 웹 앱

### SpringBoot의 내장 웹서버와 ApplicationContext의 관계
- SpringBoot는 **내장 웹서버(Embedded Web Server)** 를 지원한다.
- 따라서 `ServletWebServerApplicationContext` 계열을 사용할 경우, SpringBoot가 자동으로 **Tomcat/Jetty/Undertow 등 웹서버를 구동**한다.
- 설정이 따로 필요 없으며, 의존성만 추가하면 자동 실행된다.

### 핵심
- `ApplicationContext`는 스프링 컨테이너의 대표 인터페이스
- SpringBoot는 애플리케이션 종류에 맞는 ApplicationContext를 자동 선택
- Servlet 기반일 경우 서블릿 컨텍스트 + 내장 Tomcat이 함께 실행됨
- 리액티브 기반일 경우 리액티브 컨텍스트 + Reactor Netty 실행됨
- 일반 애플리케이션은 순수 `AnnotationConfigApplicationContext` 사용