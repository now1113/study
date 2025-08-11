package study.effective_java.ch07_람다와_스트림.item46;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    private static final List<String> words = List.of("ab", "abc", "cde");

    public static void main(String[] args) {
        groupingBy();
        groupingByAndCounting();
        groupingByAndMapping();
        toMap();
        toMapAddMerge();
        reducing();
        collectingAndThen();
    }

    private static void badCase() {
        Map<String, Long> freq = new HashMap<>();
        words.forEach(word -> {
            freq.merge(word.toLowerCase(), 1L, Long::sum);
        });
    }

    private static void groupingBy() {
        Map<Integer, List<String>> wordsByLength = words.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println(wordsByLength);
    }

    private static void groupingByAndCounting() {
        Map<Integer, Long> countByLength = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        System.out.println(countByLength);
    }

    private static void groupingByAndMapping() {
        // 단어 길이 첫 글자만 모으기
        Map<Integer, Set<Character>> initialByLength = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(w -> w.charAt(0), Collectors.toSet())
                ));

        System.out.println(initialByLength);
    }

    private static void toMap() {
        // 단어 -> 길이 Map, 키 중복시 예외 발생
        Map<String, Integer> wordLength = words.stream()
                .collect(Collectors.toMap(
                        w -> w,
                        String::length
                ));

        System.out.println(wordLength);
    }

    private static void toMapAddMerge() {
        // 키 중복 허용하려면 merge 함수 추가
        Map<Integer, String> sample = Stream.of("a", "bb", "cc")
                .collect(Collectors.toMap(
                        String::length,
                        w -> w,
                        (s1, s2) -> s1 + "," + s2
                ));
        System.out.println(sample);
    }

    private static void reducing() {
        Integer totalLength = words.stream()
                .map(String::length)
                .reduce(0, Integer::sum);
        System.out.println(totalLength);
    }

    private static void collectingAndThen() {
        Map<Integer, List<String>> immutableLists = words.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList)
                ));

        System.out.println(immutableLists);
    }
}
