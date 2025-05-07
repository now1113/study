package argo.level1;

import java.util.stream.Stream;

public class 최대공약수와최소공배수 {

    public static void main(String[] args) {
        int[] solution = solution(3, 12);
        int gcd = gcd(2, 5);
        System.out.println("gcd = " + gcd);
        int lcm = lcm(2, 5);
        System.out.println("lcm = " + lcm);
    }

    private static int[] solution(int n, int m) {
        return Stream.of(gcd(n, m), lcm(n, m)).mapToInt(Integer::intValue).toArray();
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
