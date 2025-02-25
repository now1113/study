package argo.level1;

public class 자연수뒤집어배열로 {

    public static void main(String[] args) {
        int[] solution = solution(12345);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    private static int[] solution(long n) {
        String str = String.valueOf(n);
        int[] answer = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            answer[i] = Character.getNumericValue(str.charAt(str.length() - 1 - i));
        }
        return answer;
    }
}
