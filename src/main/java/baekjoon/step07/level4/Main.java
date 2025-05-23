package baekjoon.step07.level4;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[][] paper = new boolean[100][100];
        int n = sc.nextInt(); // 색종이 수

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();   // x좌표
            int y = sc.nextInt();   // y좌표

            // (x,y)부터 10x10 영역을 true로
            for (int row = x; row < x + 10; row++) {
                for (int col = y; col < y + 10; col++) {
                    paper[row][col] = true;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (paper[i][j]) area++;
            }
        }

        System.out.println(area);
    }
}
