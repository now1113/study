package argo.level1;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 없는숫자더하기 {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6, 7, 8, 0};
        int solution = solution(arr);
        System.out.println("solution = " + solution);
    }

    private static int solution(int[] numbers) {
        return IntStream.rangeClosed(1,9).sum() - Arrays.stream(numbers).sum();
    }
}
