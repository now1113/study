package study.effective_java.ch07_람다와_스트림.item43;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Stream.of("1", "2", "3")
                .map(s -> Integer.parseInt(s))
                .toList();

        Stream.of("1", "2", "3")
                .map(Integer::parseInt)
                .toList();

        String[] words = {"Apple", "Banana", "Cherry"};
        Arrays.stream(words)
                .map(s -> s.toLowerCase())
                .forEach(System.out::println);

        Arrays.stream(words)
                .map(String::toLowerCase)
                .forEach(System.out::println);

        List<String> wordList = Arrays.asList(words);
        TreeSet<String> treeSet = wordList.stream()
                .collect(Collectors.toCollection(() -> new TreeSet<>()));
        TreeSet<String> treeSet2 = wordList.stream()
                .collect(Collectors.toCollection(TreeSet::new));

        wordList.stream()
                .map(x -> x.trim().toLowerCase()) // 메서드 참조 사용 불가
                .toList();
    }
}
