## Spring Security란?

- Spring기반 애플리케이션의 **인증(Authentication)** 과 **인가(Authorization)** 를 담당하는 보안 프레임워크
- **Filter 기반으로 동작**하며, 서블릿 필터 체인 앞단에서 보안 처리를 담당

### 주요 기능

- 인증(로그인)
- 인가(권한체크)
- CSRF 보호
- 세션 관리
- 패스워드 인코딩
- 보안 관련 커스터마이징 유연성


### Spring Security 핵심 개념

| 개념                                     | 설명                                       |
| -------------------------------------- | ---------------------------------------- |
| `SecurityFilterChain`                  | 여러 보안 필터들이 등록되는 필터 체인. HTTP 요청을 먼저 감지    |
| `Authentication`                       | 인증 정보를 담는 객체. 보통 사용자 아이디, 패스워드, 권한 정보 포함 |
| `AuthenticationManager`                | 인증 처리 매니저. 토큰을 받아 사용자 정보를 인증             |
| `UsernamePasswordAuthenticationFilter` | 폼 로그인 요청을 가로채는 기본 필터                     |
| `UserDetailsService`                   | 사용자 정보를 조회하는 서비스. DB에서 사용자 조회 로직 담당      |
| `UserDetails`                          | 사용자 인증 정보를 담는 객체                         |
| `GrantedAuthority`                     | 사용자의 권한 정보를 담는 객체                        |
| `PasswordEncoder`                      | 비밀번호 암호화 처리. 기본은 BCrypt 사용               |
| `SecurityContextHolder`                | 현재 인증된 사용자의 정보를 보관하는 ThreadLocal 저장소     |
| `@PreAuthorize`, `@Secured`            | 메서드 수준의 권한 체크 애노테이션                      |



## Spring Security 인증 흐름

```text
[사용자] -> HTTP 요청 (로그인 등) -> SecurityFilterChain -> UsernamePasswordAuthenticationFilter
-> AuthenticationManager -> UserDetailsService -> UserDetails
-> UsernamePasswordAuthenticationToken -> SecurityContextHolder 저장 -> Controller 진입
```

### HTTP 요청이 들어오면?

- 사용자가 `/login` 같은 로그인 URL로 POST 요청을 보냄 (ID/PW 포함)
- 이 요청은 DispatcherServlet보다 먼저, **Spring Security의 Filter Chain**을 통과함
- `SecurityFilterChain`은 내부적으로 **여러 개의 보안 필터**를 갖고 있는데, 이 중에 `UsernamePasswordAuthenticationFilter`가 로그인 요청을 담당

