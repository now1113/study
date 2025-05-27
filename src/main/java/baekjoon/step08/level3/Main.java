package baekjoon.step08.level3;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int price = Integer.parseInt(br.readLine());

            int quarter = price / 25;
            price %= 25;

            int dime = price / 10;
            price %= 10;

            int nickel = price / 5;
            price %= 5;

            int penny = price / 1;

            System.out.println(quarter + " " + dime + " " + nickel + " " + penny);
        }

        br.close();
    }
}
