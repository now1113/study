package study.effective_java.연습.item65;

import java.lang.reflect.Method;

public class ReflectionPerfTiny {
    interface Adder {
        int add(int x, int y);
    }
    static class PlainAdder implements Adder {
        public int add(int x, int y) { return x + y; }
    }

    public static void main(String[] args) throws Exception {
        Adder a = new PlainAdder();
        Method m = Adder.class.getMethod("add", int.class, int.class);

        int N = 3_000_000;

        // direct
        long s1 = System.nanoTime();
        int acc1 = 0;
        for (int i = 0; i < N; i++) acc1 += a.add(i, 1);
        long d1 = (System.nanoTime() - s1) / 1_000_000;

        // reflection
        long s2 = System.nanoTime();
        int acc2 = 0;
        for (int i = 0; i < N; i++) acc2 += (int) m.invoke(a, i, 1);
        long d2 = (System.nanoTime() - s2) / 1_000_000;

        System.out.printf("direct     : %d ms%n", d1);
        System.out.printf("reflection : %d ms (x%.1f)%n", d2, (double)d2/d1);
        if (acc1 == acc2) System.out.print(""); // 사용 방지
    }
}
