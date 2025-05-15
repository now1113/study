package baekjoon.step04.level4;

import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] strings) throws IOException {
        final int totalCount = 9;
        List<Integer> numbers = new ArrayList<>(totalCount);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < totalCount; i++) {
            numbers.add(Integer.parseInt(br.readLine()));
        }
        Integer maxValue = Collections.max(numbers);

        int findIndex = IntStream.range(0, numbers.size())
                .filter(i -> numbers.get(i).equals(maxValue))
                .findFirst()
                .getAsInt();

        System.out.println(maxValue);
        System.out.println(findIndex + 1);

        br.close();
    }
}
