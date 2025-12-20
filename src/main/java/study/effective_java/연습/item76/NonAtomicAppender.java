package study.effective_java.연습.item76;

import java.util.List;

public class NonAtomicAppender {
    public void appendParsedIntegers(List<String> src, List<Integer> dest) {
        for (String s : src) {
            // 이 부분에서 예외가 터지면, 그 전까지 dest.add(...)된 값이 남아버림
            dest.add(Integer.parseInt(s));
        }
    }
}
