package baekjoon.step02.level1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        solution(a, b);
    }

    private static void solution(int a, int b) {
        if (a > b) {
            System.out.println(">");
            return;
        }
        if (a < b) {
            System.out.println("<");
            return;
        }
        if (a == b) {
            System.out.println("==");
        }
    }
}
