package baekjoon.step08.level4;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int size = (int) Math.pow(2, n) + 1;
        int result = size * size;
        System.out.println(result);
    }
}
