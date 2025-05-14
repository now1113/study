package baekjoon.step04.level1;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = Integer.parseInt(br.readLine());
        List<Integer> numbers = parseNumbers(br.readLine(), totalCount);
        int target = Integer.parseInt(br.readLine());

        long count =  numbers.stream().filter(n -> n == target).count();
        System.out.println(count);

        br.close();
    }

    private static List<Integer> parseNumbers(String line, int totalCount) {
        StringTokenizer st = new StringTokenizer(line);
        List<Integer> numbers = new ArrayList<>(totalCount);

        for (int i = 0; i < totalCount; i++) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }

        return numbers;
    }
}
