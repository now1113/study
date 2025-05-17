package baekjoon.step05.level8;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> words = new ArrayList<>();

        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }

        System.out.println(words.size());

        br.close();
    }
}
