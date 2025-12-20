package study.effective_java.연습.item76;

import java.util.ArrayList;
import java.util.List;

public class AtomicAppender {
    public void appendParsedIntegers(List<String> src, List<Integer> dest) {
        // 실패 가능한 작업을 임시 공간에서 끝내고
        List<Integer> parsed = new ArrayList<>(src.size());
        for (String s : src) {
            parsed.add(Integer.parseInt(s));
        }

        // 이 부분까지 도달했다는 건 파싱이 전부 성공 -> 한번에 반영
        dest.addAll(parsed);
    }
}
