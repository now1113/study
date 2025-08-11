package study.effective_java.ch04_클래스와_인터페이스.item22;

public class Idol implements Singer{
    @Override
    public void sing() {
        System.out.println("sing");
    }
}
