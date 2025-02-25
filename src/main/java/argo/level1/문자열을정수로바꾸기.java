package argo.level1;


public class 문자열을정수로바꾸기 {

    public static void main(String[] args) {

        int solution = solution("1234");
        int solution1 = solution("-1234");

        System.out.println(solution);
        System.out.println(solution1);
    }

    private static int solution(String s) {
        return Integer.parseInt(s);
    }
}
