package baekjoon.step02.level7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();

        StringTokenizer st = new StringTokenizer(readLine);

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        int third = Integer.parseInt(st.nextToken());

        solution(first, second, third);

        br.close();
    }

    private static void solution(int first, int second, int third) {
        int threePleCase = 1000;
        int doubleCase = 100;
        int oneCase = 100;

        if (first == second && second == third) {
            int result = 10000 + first * threePleCase;
            System.out.println(result);
            return;
        }
        if (first == second || first == third) {
            int result = 1000 + first * doubleCase;
            System.out.println(result);
            return;
        }
        if (second == third) {
            int result = 1000 + second * doubleCase;
            System.out.println(result);
            return;
        }
        int max = Math.max(first, Math.max(second, third));
        System.out.println(max * oneCase);
    }

}
