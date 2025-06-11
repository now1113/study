package study.effective_java.item32;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

    }

    @SafeVarargs
    static <T> void dangerous(List<T>... lists) {
        Object[] array = lists;
        array[0] = List.of(43);
        String s = (String) lists[0].get(0);
    }

    static <T> List<T> flatten(List<List<T>> lists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : lists) result.addAll(list);
        return result;
    }

    @SafeVarargs
    public static <T> List<T> safeFlatten(List<T>... lists) {
        List<T> result = new ArrayList<>();
        for (List<T> list : lists) result.addAll(list);
        return result;
    }

    @SafeVarargs
    static <T> void notSafe(List<T>... lists) {
        Object[] array = lists;
        array[0] = List.of(42);
    }

}
