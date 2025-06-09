package study.effective;

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
