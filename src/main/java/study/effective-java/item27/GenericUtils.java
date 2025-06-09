package study.effective;

import java.lang.reflect.Array;

public class GenericUtils {

    private GenericUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] newArray(Class<T> type, int size) {
        return (T[]) Array.newInstance(type, size);
    }
}
