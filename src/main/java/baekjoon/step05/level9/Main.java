package baekjoon.step05.level9;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<String> words = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();

        while (st.hasMoreTokens()) {
            words.add(st.nextToken());
        }

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            sb.reverse();
            numbers.add(Integer.parseInt(sb.toString()));
        }

        System.out.println(Collections.max(numbers));


    }
}
