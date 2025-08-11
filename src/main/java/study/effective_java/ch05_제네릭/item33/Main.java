package study.effective_java.ch05_제네릭.item33;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.putFavorite(String.class, "hello");
        f.putFavorite(Integer.class, 123);

        String s = f.getFavorite(String.class);
        Integer i = f.getFavorite(Integer.class);

        Map<Class<?>, Object> map = new HashMap<>();
        map.put(String.class, 123); // 실수

        String s2 = (String) map.get(String.class); // ClassCastException
    }
}
