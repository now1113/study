package baekjoon.step05.level3;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCount = Integer.parseInt(br.readLine());
        List<String> stringList = new ArrayList<>(testCount);

        for (int i = 0; i < testCount; i++) {
            stringList.add(br.readLine());
        }

        for (String string : stringList) {
            char first = string.charAt(0);
            char end = string.charAt(string.length() - 1);

            if (string.length() == 1) {
                end = string.charAt(0);
            }

            System.out.println(first + "" + end);
        }
    }
}
