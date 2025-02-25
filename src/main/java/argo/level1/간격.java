package argo.level1;

public class 간격 {

    public static void main(String[] args) {
        long[] solution = solution(2, 5);

        System.out.println(solution);
        for (long l : solution) {
            System.out.println(l);
        }
    }

    private static long[] solution(int x, int n) {
        long[] answer = new long[n];

        for (int i = 0; i < n; i++) {
            answer[i] = (long) x * (i + 1);
        }

        return answer;
    }
}
