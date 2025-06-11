package study.effective_java.item18;

import java.util.HashSet;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        InstrumentedHashSet<String> set = new InstrumentedHashSet<>();
        set.addAll(List.of("a", "b", "c"));
        System.out.println(set.getAddCount()); //6

        InstrumentedSet<String> set2 = new InstrumentedSet<>(new HashSet<>());
        set2.addAll(List.of("a", "b", "c"));
        System.out.println(set2.getAddCount()); // 3
    }
}
