package argo.level1;

import java.util.stream.IntStream;

public class 서울에서김서방찾기 {

    public static void main(String[] args) {
        String[] strings = {"Jane", "Kim"};

        String solution = solution(strings);
        System.out.println("solution = " + solution);
    }

    private static String solution(String[] seoul) {
        int index = IntStream.range(0, seoul.length)
                .filter(i -> "Kim".equals(seoul[i]))
                .findFirst()
                .orElse(-1);

        return "김서방은 " + index + "에 있다";
    }
}
