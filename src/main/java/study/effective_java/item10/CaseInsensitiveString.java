package study.effective_java.item10;

import java.util.Objects;

public class CaseInsensitiveString {

    private final String s;

    public CaseInsensitiveString(String s) {
        this.s = s;
    }

    @Override
    public boolean equals(Object o) {
//        if (o instanceof CaseInsensitiveString) {
//            return s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
//        }
//        // String과도 동등하게 비교
//        if (o instanceof String) {
//            return s.equalsIgnoreCase((String) o);
//        }
//        return false;
        return o instanceof CaseInsensitiveString &&
                s.equalsIgnoreCase(((CaseInsensitiveString) o).s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
}
