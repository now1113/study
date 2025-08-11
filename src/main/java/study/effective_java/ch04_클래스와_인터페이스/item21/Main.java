package study.effective_java.ch04_클래스와_인터페이스.item21;

public class Main extends MyClass implements MyInterface{

    public static void main(String[] args) {
        new Main().hello(); // interface or class ?
    }
}
