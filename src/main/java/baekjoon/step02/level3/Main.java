package baekjoon.step02.level3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        solution(sc.nextInt());
    }

    private static void solution(int year) {
        boolean isDivisibleBy4  = year % 4 == 0;
        boolean meetsLeapYearRule  = year % 100 != 0 || year % 400 == 0;

        if (isDivisibleBy4 && meetsLeapYearRule) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
