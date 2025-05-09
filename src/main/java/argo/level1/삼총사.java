package argo.level1;

import java.util.Arrays;

public class 삼총사 {

    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};
        int[] number2 = {-3, -2, -1, 0, 1, 2, 3};
        int[] number3 = {0,0,0,0};
        int solution = solution(number);
        int solution2 = solution(number2);
        int solution3 = solution(number3);
        System.out.println("solution = " + solution);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
    }

    // -5 -2 0 2 3
    private static int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length - 2; i++) {
            for (int j = i + 1; j < number.length - 1; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}
