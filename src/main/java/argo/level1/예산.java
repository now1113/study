package argo.level1;

import java.util.Arrays;

public class 예산 {

    public static void main(String[] args) {
        int[] d = {1,3,2,5,6};
        int budget = 9;

        int solution = solution(d, budget);
        System.out.println("solution = " + solution);
    }

    private static int solution(int[] d, int budget) {
        Arrays.sort(d);
        int cnt = 0;
        int sum = 0;

        // 1,2,3,4,5,6
        // 9
        for (int cost : d) {
            sum += cost;
            if (sum > budget) {
                break;
            }
            cnt++;
        }
        return cnt;
    }
}
