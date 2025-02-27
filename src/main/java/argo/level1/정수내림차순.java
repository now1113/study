package argo.level1;

import java.util.Collections;
import java.util.stream.Collectors;

public class 정수내림차순 {

    public static void main(String[] args) {
        long solution = solution(118372);
        System.out.println("solution = " + solution);
    }

    private static long solution(long n) {
        //
        return Long.parseLong(
                String.valueOf(n)
                        .chars()
                        .mapToObj(c -> (char) c)
                        .sorted(Collections.reverseOrder())
                        .map(String::valueOf)
                        .collect(Collectors.joining())
        );
    }
}
