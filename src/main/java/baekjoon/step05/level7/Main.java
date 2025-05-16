package baekjoon.step05.level7;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = Integer.parseInt(br.readLine());
        List<String> stringList = new ArrayList<>(totalCount);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int repeatCount = Integer.parseInt(st.nextToken());
            String words = st.nextToken();

            for (char c : words.toCharArray()) {
                sb.append(String.valueOf(c).repeat(repeatCount));
            }
            stringList.add(sb.toString());
            sb.setLength(0);
        }

        for (String result : stringList) {
            System.out.println(result);
        }

        br.close();
    }
}
