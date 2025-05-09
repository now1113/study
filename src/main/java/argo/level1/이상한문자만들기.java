package argo.level1;

import java.util.Arrays;
import java.util.stream.Collectors;

public class 이상한문자만들기 {

    public static void main(String[] args) {
        String value = solution("try hello world");
        System.out.println("value = " + value);
    }

    private static String solution(String s) {
        return Arrays.stream(s.split(" ", -1))
                .map(word -> {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < word.length(); i++) {
                        char c = word.charAt(i);
                        sb.append(i % 2 == 0 ? Character.toUpperCase(c) : Character.toLowerCase(c));
                    }
                    return sb.toString();
                })
                .collect(Collectors.joining(" "));
    }
}
