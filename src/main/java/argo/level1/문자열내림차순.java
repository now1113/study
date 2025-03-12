package argo.level1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순 {

    public static void main(String[] args) {
        String zbcdefg = solution("Zbcdefg");
        System.out.println("zbcdefg = " + zbcdefg);
        String a = solution("a");
        System.out.println("a = " + a);
    }

    private static String solution(String s) {
        Character[] chars = s.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);

        Arrays.sort(chars, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder(chars.length);
        for(char c : chars) sb.append(c);

        return sb.toString();
    }
}
