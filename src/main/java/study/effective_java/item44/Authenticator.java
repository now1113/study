package study.effective_java.item44;

@FunctionalInterface
interface Authenticator {
    boolean authenticate(User user, Credential credential);
}
