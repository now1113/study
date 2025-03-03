package argo.level1;

import java.util.stream.IntStream;

public class 음양더하기 {

    public static void main(String[] args) {

        int[] absolutes = {1, 2, 3};
        boolean[] signs = {false, false, true};

        int solution = solution(absolutes, signs);
        System.out.println("solution = " + solution);

    }

    private static int solution(int[] absolutes, boolean[] signs) {
        return IntStream.range(0, absolutes.length)
                .map(i -> signs[i] ? absolutes[i] : -absolutes[i])
                .sum();
    }
}
