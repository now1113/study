package argo.level1;


public class 문자열다루기기본 {

    public static void main(String[] args) {
        boolean a234 = solution("a234");
        System.out.println("a234 = " + a234);
        boolean solution = solution("1234");
        System.out.println("solution = " + solution);
    }

    private static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        return s.chars().allMatch(Character::isDigit);
    }
}
