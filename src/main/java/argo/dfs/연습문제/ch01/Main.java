package argo.dfs.연습문제.ch01;

import java.util.Scanner;

public class Main {

    public static void dfs(int n, int target) {
        if (n > target) {
            return;
        }
        System.out.println(n);
        dfs(n + 1, target);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        dfs(1, target);
    }
}
