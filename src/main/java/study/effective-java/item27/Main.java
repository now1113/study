package study.effective;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        // Unchecked call to 'add(E)' as a member of raw type 'java.util.List'
        List list = new ArrayList();
        list.add("string"); // 비 검사 경고 발생 (raw type)

        // Unchecked cast: 'java.util.ArrayList' to 'java.util.List<java.lang.String>'
        List<String> strings = (List<String>) new ArrayList();  // 형변환 비검사 경고

        String[] arr = GenericUtils.newArray(String.class, 10);
    }

//    @SuppressWarnings("unchecked")
//    public <T> T[] toArray(T[] a) {
//        return (T[]) Arrays.copyOf(elements, size, a.getClass());
//    }
}
