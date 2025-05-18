package baekjoon.step05.level10;

import java.io.*;
import java.util.*;
import java.util.stream.*;


public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        int time = 0;
        for (char word : words.toCharArray()) {
            if (word >= 'A' && word <= 'C') time += 3;
            else if (word <= 'F') time += 4;
            else if (word <= 'I') time += 5;
            else if (word <= 'L') time += 6;
            else if (word <= 'O') time += 7;
            else if (word <= 'S') time += 8;
            else if (word <= 'V') time += 9;
            else if (word <= 'Z') time += 10;
        }
        System.out.println(time);
        br.close();
    }
}
