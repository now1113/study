package study.effective_java.연습.item78;

public class ReorderExample {
    private static int a;
    private static int b;
    private static boolean ready;

    public static void writer() {
        a = 1;
        b = 2;
        ready = true;   // 공개
    }

    public static void reader() {
        if (ready) {
            System.out.println("a=" + a + ", b=" + b);
        }
    }
}
