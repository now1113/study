package baekjoon.step04.level9;

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cartCount = Integer.parseInt(st.nextToken());
        int insertCount = Integer.parseInt(st.nextToken());

        int[] numbers = new int[cartCount];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        for (int i = 0; i < insertCount; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(input.nextToken()) - 1;
            int to = Integer.parseInt(input.nextToken()) - 1;

            while (from < to) {
                int temp = numbers[from];
                numbers[from] = numbers[to];
                numbers[to] = temp;
                from++;
                to--;
            }
        }

        String result = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}
