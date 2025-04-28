package argo.level1;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {

    public static void main(String[] args) {
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        int[] solution = solution(arr);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    private static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int prev = -1;

        for (int num : arr) {
            if (num != prev) {
                list.add(num);
                prev = num;
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}
