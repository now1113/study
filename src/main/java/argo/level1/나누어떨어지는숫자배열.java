package argo.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 나누어떨어지는숫자배열 {

    public static void main(String[] args) {
        int[] arr = {2, 36, 1, 3};
        int[] solution = solution(arr, 1);

        for (int i : solution) {
            System.out.println("i = " + i);
        }

    }

    private static int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr)
                .filter(num -> num % divisor == 0)
                .sorted()
                .toArray();

        return result.length == 0 ? new int[]{-1} : result;
    }
}
