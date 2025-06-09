package study.effective;

public interface MyInterface {
    default void hello() {
        System.out.println("Hello from interface");
    }
}
