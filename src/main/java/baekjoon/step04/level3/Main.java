package baekjoon.step04.level3;

import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>(totalCount);

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < totalCount; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        Integer min = Collections.min(numbers);
        Integer max = Collections.max(numbers);

        System.out.println(min + " " + max);
        br.close();
    }
}
