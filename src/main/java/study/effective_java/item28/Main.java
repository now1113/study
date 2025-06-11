package study.effective_java.item28;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Object[] objectArray = new String[1];   // 컴파일 OK
        objectArray[0] = 42;    // 런타임 오류 발생 (ArrayStoreException)

        // List<Object> list = new ArrayList<String>(); 컴파일 에러
    }
}
