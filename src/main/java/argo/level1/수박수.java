package argo.level1;

public class 수박수 {

    public static void main(String[] args) {

        String solution = solution(3);
        String solution1 = solution(4);

        System.out.println("solution = " + solution);
        System.out.println("solution1 = " + solution1);
    }

    private static String solution(int n) {
        String answer = "수박";
        return answer.repeat(n).substring(0, n);
    }
}
