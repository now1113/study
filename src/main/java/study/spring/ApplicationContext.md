# ApplicationContext

## 요약
- **ApplicationContext**는 스프링 **IoC 컨테이너의 대표 인터페이스**로, Bean 관리(BeanFactory), 리소스 로딩(ResourceLoader), i18n(MessageSource),
이벤트 발행(ApplicationEventPublisher), 패턴 리소스 매칭(ResourcePatternResolver)를 **한데 묶은 런타임 허브**다.
- Boot에서는 `SpringApplication`이 환경과 앱 타입(MVC/Reactive/None)에 맞는 **적절한 컨텍스트 구현체**를 선택, 생성하고 `refresh()`로 전체 라이프사이클을 구동한다.
- `refresh()`는 **빈 정의 로딩 -> 후처리기(BFPP/PP) 적용 -> 싱글톤 초기화 -> 라이프사이클 시작/이벤트 발행** 순으로 진행된다.

## 무엇이, 왜 필요할까

### 역할
- Bean **정의/생성/주입/소멸**을 통합 관리한다.
- 설정, 메시지, 리소스, 이벤트, 프로파일, 스코프 등 **애플리케이션 인프라 전반**을 제공한다.

### 타입 구성
`ApplicationContext`는 아래 기능 인터페이스를 모두 구현한다.

- **ListableBeanFactory / HierarchicalBeanFactory** - 빈 관리 및 부모-자식 계층
- **EnvironmentCapable** - 환경/프로퍼티
- **MessageSource** - 국제화 메시지 해석
- **ApplicationEventPublisher** - 애플리케이션 이벤트 발행
- **ResourcePatternResolver(=ResourceLoader 확장)** - 클래스 패스/파일/URL 리소스 및 패턴 매칭 로딩

### 어떤 구현체를 언제 사용할까
주요 `ApplicationContext` 구현과 추천 상황

| 구현체                                                     | 언제/어디서                           | 특징                                                                    |
| ------------------------------------------------------- | -------------------------------- | --------------------------------------------------------------------- |
| **AnnotationConfigApplicationContext**                  | 순수 Java 앱, 테스트, CLI              | `@Configuration`/컴포넌트 스캔 기반. 간단한 부트스트랩에 적합.                           |
| **GenericApplicationContext**                           | **프레임워크/라이브러리 작성**, 기능 테스트       | 내부에 `DefaultListableBeanFactory`. 코드로 `registerBean` 등 **함수형 등록** 가능. |
| **GenericWebApplicationContext**                        | 웹 환경에서 수동 부트스트랩                  | Web 전용 확장 포인트(`ThemeSource`, `ConfigurableWebApplicationContext`).    |
| **AnnotationConfigServletWebServerApplicationContext**  | Boot MVC (Tomcat/Jetty/Undertow) | 웹 서버를 **onRefresh** 단계에서 부팅.                                          |
| **AnnotationConfigReactiveWebServerApplicationContext** | Boot WebFlux                     | Netty 등 **리액티브 서버**를 onRefresh에서 부팅.                                  |
| **StaticApplicationContext**                            | 소형 테스트/샘플                        | 외부 설정 없이 프로그램적으로 빈/메시지 등록.                                            |

> Boot는 **웹 타입**(MVC/Reactive/None)을 감지해 위 구현중 하나를 자동 선택한다.

