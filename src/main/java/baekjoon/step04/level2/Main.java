package baekjoon.step04.level2;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int totalCount =  Integer.parseInt(st.nextToken());
        int targetNumber = Integer.parseInt(st.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        List<Integer> numbers = new ArrayList<>(totalCount);

        for (int i = 0; i < totalCount; i++) {
            numbers.add(Integer.parseInt(st2.nextToken()));
        }

        List<Integer> collect = numbers.stream()
                .filter(number -> number < targetNumber)
                .collect(Collectors.toList());

        String result = collect.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
        br.close();
    }
}
