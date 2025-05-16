package baekjoon.step04.level10;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int scoreCount = Integer.parseInt(br.readLine());

        List<Integer> scores = new ArrayList<>(scoreCount);

        StringTokenizer st = new StringTokenizer(br.readLine());

        while (st.hasMoreTokens()) {
            scores.add(Integer.parseInt(st.nextToken()));
        }


        Integer max = Collections.max(scores);

        double avg = scores.stream()
                .mapToDouble(score -> (double) score / max * 100)
                .average()
                .orElse(0.0);
        System.out.println(avg);

        br.close();
    }
}
