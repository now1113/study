package argo.level1;

public class 삼진법뒤집기 {

    public static void main(String[] args) {
        int solution = solution(45);
        System.out.println("solution = " + solution);
    }

    private static int solution(int n) {
        if (n == 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(n % 3);
            n /= 3;
        }

        return Integer.parseInt(sb.toString(), 3);
    }
}
