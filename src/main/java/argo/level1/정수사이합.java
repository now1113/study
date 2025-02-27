package argo.level1;

public class 정수사이합 {

    public static void main(String[] args) {
        long solution = solution(3, 5);
        System.out.println("solution = " + solution);
    }

    private static long solution(int a, int b) {
        //
        int min = Math.min(a, b);
        int max = Math.max(a, b);

        return (long) (max - min + 1) * (min + max) / 2;
    }

}
