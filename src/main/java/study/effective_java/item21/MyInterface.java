package study.effective_java.item21;

public interface MyInterface {
    default void hello() {
        System.out.println("Hello from interface");
    }
}
