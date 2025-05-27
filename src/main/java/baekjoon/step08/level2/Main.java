package baekjoon.step08.level2;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num = Integer.parseInt(st.nextToken());
        int formation = Integer.parseInt(st.nextToken());

        System.out.println(Integer.toString(num, formation).toUpperCase());

        br.close();
    }
}
