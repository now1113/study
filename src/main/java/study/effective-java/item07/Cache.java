package study.effective;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.WeakHashMap;

public class Cache {
    private static final Map<Integer, Object> cache = new HashMap<>();
    private static final Map<Integer, Object> weakCache = new WeakHashMap<>();
    private static final Map<Integer, Object> linkCache = new LinkedHashMap<Integer, Object>(16, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry<Integer, Object> eldest) {
            return size() > 100; // 100개 이상이면 가장 오래된 항목 제거
        }
    };

    public static void addToCache(int key, Object value) {
        cache.put(key, value);
    }


}
