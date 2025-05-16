package baekjoon.step05.level5;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalCount = Integer.parseInt(br.readLine());
        int sum = 0;
        String numbers = br.readLine();

        for (int i = 0; i < totalCount; i++) {
            sum += numbers.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}
