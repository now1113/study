package argo.level1;

public class 짝수와홀수 {

    public static void main(String[] args) {
        String solution = solution(4);
        System.out.println("solution = " + solution);
    }

    private static String solution(int num) {
        if (num % 2 == 0) {
            return "Even";
        }
        return "Odd";
    }
}
