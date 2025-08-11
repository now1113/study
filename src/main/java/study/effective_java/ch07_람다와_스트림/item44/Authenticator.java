package study.effective_java.ch07_람다와_스트림.item44;

@FunctionalInterface
interface Authenticator {
    boolean authenticate(User user, Credential credential);
}
