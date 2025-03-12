package argo.level1;

public class 약수의개수와덧셈 {

    public static void main(String[] args) {
        int solution = solution(13, 17);
        System.out.println("solution = " + solution);
    }

    private static int solution(int left, int right) {
        // 완전제곱수 -> 중복된 약수를 가지므로 개수가 홀수가 됨.
        int sum = 0;
        for (int i = left; i <= right; i++) {
            if (Math.sqrt(i) == (int) Math.sqrt(i)) {
                sum -= i;
            } else {
                sum += i;
            }
        }
        return sum;
    }
}
