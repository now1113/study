package argo.level1;

import java.util.Arrays;

public class 제일작은수제거하기 {

    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 1};
        int[] solution = solution(arr);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    private static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr)
                .min()
                .getAsInt();

        return Arrays.stream(arr)
                .filter(i -> i != min)
                .toArray();
    }
}
