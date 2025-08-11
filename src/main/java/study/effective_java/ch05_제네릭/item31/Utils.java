package study.effective_java.ch05_제네릭.item31;

import java.util.List;

public class Utils {
    private Utils() {
    }

//    public static <T> void copy(List<T> src, List<T> dest) {
//        for (T t : src) dest.add(t);
//    }

    public static <T> void copy(List<? extends T> src, List<? super T> dest) {
        for (T t : src) dest.add(t);
    }

    public static <T> void process(List<T> list) {
        T t = list.get(0);
        list.add(t);    // T로 읽고 쓰는 동시에 사용
    }
}
