package study.effective_java.ch04_클래스와_인터페이스.item19;

public class Main {

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();

        Child child = new Child();
        child.template();
    }
}
