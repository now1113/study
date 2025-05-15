package baekjoon.step04.level6;

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

        for (int i = 0; i < cart.length; i++) {
            cart[i] = i + 1;
        }

        for (int i = 0; i < insertCount; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(input.nextToken()) - 1;
            int to = Integer.parseInt(input.nextToken()) - 1;

            int temp = cart[from];
            cart[from] = cart[to];
            cart[to] = temp;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : cart) {
            sb.append(num).append(" ");
        }

        System.out.println(sb.toString().trim());

        br.close();
    }
}

