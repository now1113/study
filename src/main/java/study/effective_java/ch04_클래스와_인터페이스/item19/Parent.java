package study.effective_java.ch04_클래스와_인터페이스.item19;

public class Parent {
    public void template() {
        // 공통 로직
        System.out.println("Parent 1:");
        hook(); // hook method
        System.out.println("Parent 2:");
    }
    protected void hook() {
        // 하위 클래스가 override 가능
    }
}
