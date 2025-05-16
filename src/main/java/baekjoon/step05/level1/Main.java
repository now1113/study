package baekjoon.step05.level1;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word = br.readLine();
        int targetIndex = Integer.parseInt(br.readLine());

        System.out.println(word.charAt(targetIndex - 1));
    }
}
