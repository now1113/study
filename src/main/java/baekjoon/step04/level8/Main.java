package baekjoon.step04.level8;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> remainders  = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int number = Integer.parseInt(br.readLine());
            remainders.add(number % 42);
        }

        System.out.println(remainders.size());

        br.close();
    }
}
