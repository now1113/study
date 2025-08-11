package study.effective_java.ch04_클래스와_인터페이스.item20;

public interface HelloService {

    default void sayHello() {
        System.out.println("Hello");
    }

    void say2();
}
