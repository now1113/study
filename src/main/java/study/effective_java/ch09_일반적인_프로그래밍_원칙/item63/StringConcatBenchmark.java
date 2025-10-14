package study.effective_java.ch09_일반적인_프로그래밍_원칙.item63;

import java.util.function.IntFunction;

public class StringConcatBenchmark {

    private static volatile int blackhole;

    public static void main(String[] args) {
        int[] sizes = {5_000, 30_000, 60_000};

        for (int i = 0; i < 3; i++) {
            run("warmup-plus", StringConcatBenchmark::plusInLoop, 10_000);
            run("warmup-builder", StringConcatBenchmark::builder, 10_000);
            run("warmup-builder-presized", StringConcatBenchmark::builderPresized, 10_000);
        }

        System.out.println("=== Benchmark Start ===");
        for (int n : sizes) {
            System.out.printf("-- N = %,d --%n", n);
            run("plusInLoop",            StringConcatBenchmark::plusInLoop, n);
            run("builder(default cap)",  StringConcatBenchmark::builder,     n);
            run("builder(pre-sized)",    StringConcatBenchmark::builderPresized, n);
            System.out.println();
        }
    }

    private static void run(String name, IntFunction<String> fn, int n) {
        long t0 = System.nanoTime();
        String s = fn.apply(n);
        long t1 = System.nanoTime();
        long ms = (t1 - t0) / 1_000_000;
        blackhole ^= s.hashCode();
        System.out.printf("%-22s : %6d ms (length=%d)%n", name, ms, s.length());
    }

    private static String plusInLoop(int n) {
        String s = "";
        for (int i = 0; i < n; i++) {
            s = s + 'a';
        }
        return s;
    }

    private static String builder(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    private static String builderPresized(int n) {
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            sb.append('a');
        }
        return sb.toString();
    }
}
