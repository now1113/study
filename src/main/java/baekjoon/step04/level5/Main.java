package baekjoon.step04.level5;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int cartCount = Integer.parseInt(st.nextToken());
        int insertCount = Integer.parseInt(st.nextToken());

        int[] cart = new int[cartCount];

        for (int i = 0; i < insertCount; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(input.nextToken());
            int to = Integer.parseInt(input.nextToken());
            int number = Integer.parseInt(input.nextToken());

            for (int j = from - 1; j <= to - 1; j++) {
                cart[j] = number;
            }
        }

        String result = Arrays.stream(cart)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        System.out.println(result);
    }
}
