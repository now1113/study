package argo.level1;

import java.util.Arrays;

public class 평균구하기 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        double solution = solution(arr);
        System.out.println("solution = " + solution);
    }

    private static double solution(int[] arr) {
        return Arrays.stream(arr)
                .average()
                .getAsDouble();
    }
}
