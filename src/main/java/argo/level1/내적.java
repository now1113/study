package argo.level1;

import java.util.stream.IntStream;

public class 내적 {

    public static void main(String[] args) {

        // -3 -2 0 8
        int[] a = {1, 2, 3, 4};
        int[] b = {-3, -1, 0, 2};

        int solution = solution(a, b);  // 3
        System.out.println("solution = " + solution);

    }

    private static int solution(int[] a, int[] b) {
        return IntStream.range(0, a.length)
                .map(i -> a[i] * b[i])
                .sum();
    }
}
