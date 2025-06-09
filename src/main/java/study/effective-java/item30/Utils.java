package study.effective;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Utils {
    public static <T> List<T> toList(T... elements) {
        return Arrays.asList(elements);
    }

    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static <T extends Comparable<T>> T max(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("빈 리스트");
        }
        T result = list.get(0);
        for (T t : list) {
            if (t.compareTo(result) > 0) {
                result = t;
            }
        }
        return result;
    }

    public static <T> void printList(List<T> list) {
        System.out.println("hi");
    }
}
