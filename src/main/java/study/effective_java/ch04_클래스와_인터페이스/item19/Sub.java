package study.effective_java.ch04_클래스와_인터페이스.item19;

public final class Sub extends Super{

    private final String message;

    public Sub() {
        this.message = "Hello";
    }

    @Override
    public void overrideMe() {
        System.out.println("message = " + message);
    }
}
