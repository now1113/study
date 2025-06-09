package study.effective;

public interface HelloService {

    default void sayHello() {
        System.out.println("Hello");
    }

    void say2();
}
