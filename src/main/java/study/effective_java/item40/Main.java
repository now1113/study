package study.effective_java.item40;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Bigram> s = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            s.add(new Bigram('a', 'b'));
        }
        System.out.println(s.size());   // 기댓값: 1, 실제 출력: 10
    }
}
