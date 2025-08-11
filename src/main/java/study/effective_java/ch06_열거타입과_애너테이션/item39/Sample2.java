package study.effective_java.ch06_열거타입과_애너테이션.item39;

public class Sample2 {

    @ExceptionTest(ArithmeticException.class)
    public static void m1() {
        int x = 1 / 0;
    }

    @ExceptionTest(NullPointerException.class)
    public static void m2() {
        throw new IllegalArgumentException();
    }

    @ExceptionTest(IndexOutOfBoundsException.class)
    public static void m3() {
        int[] arr = new int[1];
        int a = arr[2];
    }
}
