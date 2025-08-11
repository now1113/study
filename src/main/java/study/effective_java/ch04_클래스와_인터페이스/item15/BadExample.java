package study.effective_java.ch04_클래스와_인터페이스.item15;

import java.util.ArrayList;
import java.util.List;

public class BadExample {
    public static final List<String> NAMES = new ArrayList<>();

    public static final String HI = "HI";

    public static List<String> getNames() {
        return NAMES;
    }
}
