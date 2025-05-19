package argo.dfs.타겟넘버;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] numbers;
    static int target;
    static int answer;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 1, 1}, 3));
    }

    public static int solution(int[] nums, int tgt) {
        numbers = nums;
        target = tgt;
        answer = 0;

        dfs(0, 0);

        return answer;
    }

    public static void dfs(int index, int sum) {
        if (index == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }

        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
