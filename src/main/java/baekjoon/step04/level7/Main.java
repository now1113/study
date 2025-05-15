package baekjoon.step04.level7;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        final int totalStudents  = 30;
        final int submitCount = 28;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] submitted = new boolean[totalStudents + 1];

        for (int i = 0; i < submitCount; i++) {
            int num = Integer.parseInt(br.readLine());
            submitted[num] = true;
        }

        for (int i = 1; i <= totalStudents; i++) {
            if (!submitted[i]) {
                System.out.println(i);
            }
        }

        br.close();
    }
}
