package study.effective_java.ch04_클래스와_인터페이스.item21;

public interface MyInterface {
    default void hello() {
        System.out.println("Hello from interface");
    }
}
