package argo.level1;

public class 정수제곱근판별 {

    public static void main(String[] args) {
        long solution = solution(121);
        //144
        System.out.println("solution = " + solution);
    }

    private static long solution(long n) {
        double sqrt = Math.sqrt(n);

        if (sqrt % 1 != 0) {
            return -1;
        }
        return (long) Math.pow(sqrt + 1, 2);
    }
}
