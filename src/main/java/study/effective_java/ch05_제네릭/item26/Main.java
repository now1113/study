package study.effective_java.ch05_제네릭.item26;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void unsafeAdd(List list, Object o) {
        list.add(o);
    }

    public static <T> void safeAdd(List<T> list, T o) {
        list.add(o);
    }

    public static void main(String[] args) {
        // raw type
//        List list = new ArrayList();
//        list.add("hello");
//        list.add(123);

        // ClassCastException
//        String s = (String) list.get(1);

//        List<String> list2 = new ArrayList<>();
//        list2.add("hello");

        List<String> strings = new ArrayList<>();
        unsafeAdd(strings, 42);
        safeAdd(strings, "1234");

        String s = strings.get(0);
    }
}
