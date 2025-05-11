package baekjoon.step02.level6;

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
        int cookTime = Integer.parseInt(br.readLine());

        solution(hour, minute, cookTime);

        br.close();
    }

    private static void solution(int hour, int minute, int cookTime) {
        int totalMinutes = hour * 60 + minute + cookTime;

        int resultHour = (totalMinutes / 60) % 24;
        int resultMinute = totalMinutes % 60;



        System.out.printf("%d %d\n", resultHour, resultMinute);


    }
}
