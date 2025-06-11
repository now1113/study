package study.effective_java.item30;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        List<String> names = Utils.toList("kim", "hyeon", "je");
        List<Integer> nums = Utils.toList(1, 2, 3);

        Set<String> set1 = Set.of("A", "B");
        Set<String> set2 = Set.of("B", "C");

        Set<String> result = Utils.union(set1, set2);

        Utils.printList(Arrays.asList("a", "b"));
        Utils.printList(null);
    }
}
