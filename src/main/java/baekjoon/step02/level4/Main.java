package baekjoon.step02.level4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());
        solution(x, y);
        br.close();
    }

    private static void solution(int x, int y) {
        boolean isQuadrant1Case = x > 0 && y > 0;
        boolean isQuadrant2Case = x < 0 && y > 0;
        boolean isQuadrant3Case = x < 0 && y < 0;
        boolean isQuadrant4Case = x > 0 && y < 0;

        if (isQuadrant1Case) {
            System.out.println("1");
            return;
        }
        if (isQuadrant2Case) {
            System.out.println("2");
            return;
        }
        if (isQuadrant3Case) {
            System.out.println("3");
            return;
        }
        if (isQuadrant4Case) {
            System.out.println("4");
        }
    }
}
