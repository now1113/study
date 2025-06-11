package study.effective_java.item19;

public class Main {

    public static void main(String[] args) {
        Sub sub = new Sub();
        sub.overrideMe();

        Child child = new Child();
        child.template();
    }
}
