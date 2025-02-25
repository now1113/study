package argo.level1;

public class 나머지가1이되는수 {

    public static void main(String[] args) {
        int solution = solution(12);
        System.out.println("solution = " + solution);
    }

    private static int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return -1;
    }

}
