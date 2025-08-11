package study.effective_java.ch07_람다와_스트림.item42;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry");

        Collections.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });

        Collections.sort(words, (s1 ,s2) -> Integer.compare(s1.length(), s2.length()));

        words.sort(Comparator.comparing(String::length));

        Task task = new Task() {
            @Override
            void execute() {
                System.out.println("running");
            }
        };
    }
}
