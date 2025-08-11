package study.effective_java.ch07_람다와_스트림.item45;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> dictionary = List.of("a", "b", "c");
        Map<String, Set<String>> anagrams = new HashMap<>();

        for (String word : dictionary) {
            String key = alphabetize(word);
            Set<String> words = anagrams.get(key);
            if (words == null) {
                anagrams.put(key, words = new HashSet<>());
            }
            words.add(word);
        }

        Map<String, Set<String>> anagrams2 = dictionary.stream()
                .collect(Collectors.groupingBy(
                        w -> alphabetize(w),
                        Collectors.toSet()
                ));
    }

    private static String alphabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);
        return new String(a);
    }
}
