package study.effective_java.item20;

public interface HelloService {

    default void sayHello() {
        System.out.println("Hello");
    }

    void say2();
}
