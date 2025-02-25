package argo.level1;

public class 자릿수더하기 {

    public static void main(String[] args) {
        int solution = solution(123);
        System.out.println("solution = " + solution);
    }

    private static int solution(int n) {
        int answer = 0;
        String strings = String.valueOf(n);
        for (int i = 0; i < strings.length(); i++) {
            answer += Integer.parseInt(String.valueOf(strings.charAt(i)));
        }

        return answer;
    }
}
