package study.effective_java.item19;

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
