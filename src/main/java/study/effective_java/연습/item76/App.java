package study.effective_java.연습.item76;

import java.util.ArrayList;
import java.util.List;

public class App {

    /**
     * [nonAtomicAppender] failed: NumberFormatException
     * [nonAtomicAppender] dest = [100, 1, 2]
     * [Atomic] failed: NumberFormatException
     * [Atomic] dest = [100]
     */
    void main() {
        List<Integer> dest = new ArrayList<>();
        dest.add(100);

        List<String> src = List.of("1", "2", "x", "3");

        NonAtomicAppender nonAtomicAppender = new NonAtomicAppender();

        try {
            nonAtomicAppender.appendParsedIntegers(src, dest);
        } catch (RuntimeException e) {
            System.out.println("[nonAtomicAppender] failed: " + e.getClass().getSimpleName());
        }
        // 100, 1, 2 처럼 부분 반영 가능
        System.out.println("[nonAtomicAppender] dest = " + dest);

        dest.clear();
        dest.add(100);

        AtomicAppender atomic = new AtomicAppender();
        try {
            atomic.appendParsedIntegers(src, dest);
        } catch (RuntimeException e) {
            System.out.println("[Atomic] failed: " + e.getClass().getSimpleName());
        }
        // 실패 시 100 그대로 유지
        System.out.println("[Atomic] dest = " + dest);
    }
}
