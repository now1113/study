package study.effective_java.item06;

import java.util.regex.Pattern;

public class RomanNumerals {

    private static final Pattern ROMAN = Pattern.compile("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");

    public static boolean isRomanNumerals(String s) {
        return s.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$"); // 불필요한 Pattern 객체 생성
    }

    public static boolean isRomanNumeralsV2(String s) {
        return ROMAN.matcher(s).matches();
    }
}
