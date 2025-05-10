package baekjoon.step02.level5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String readLine = br.readLine();
        StringTokenizer st = new StringTokenizer(readLine);

        int hour = Integer.parseInt(st.nextToken());
        int minute = Integer.parseInt(st.nextToken());

        solution(hour, minute);
        br.close();
    }

    private static void solution(int hour, int minute) {
        minute -= 45;

        if (minute < 0) {
            minute += 60;
            hour--;
            if (hour < 0) {
                hour = 23;
            }
        }

        System.out.printf("%d %d\n", hour, minute);
    }
}
