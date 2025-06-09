package study.effective;

import java.util.ArrayList;
import java.util.List;

public class BadExample {
    public static final List<String> NAMES = new ArrayList<>();

    public static final String HI = "HI";

    public static List<String> getNames() {
        return NAMES;
    }
}
