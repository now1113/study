package argo.level1;


public class 핸드폰번호가리기 {

    public static void main(String[] args) {
        String solution = solution("01033334444");
        System.out.println("solution = " + solution);
    }

    private static String solution(String phoneNumber) {
        int size = phoneNumber.length();
        return "*".repeat(size - 4) + phoneNumber.substring(size - 4);
    }

}
