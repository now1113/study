package study.effective_java.ch07_람다와_스트림.item48;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main {

    private static List<Member> members;

    public static void main(String[] args) {
        parallelForEach();
    }

    // 외부 리스트 변경 -> 경쟁 조건
    private static void parallelForEach() {
        List<String> names = new ArrayList<>();

        members.parallelStream()
                .map(Member::getName)
                .forEach(names::add);
    }

    // 수집기로 병렬 안전 처리
    private static void parallelForEachSolve() {

        List<String> names = members.parallelStream()
                .map(Member::getName)
                .toList();
    }

    // 누적자에 부수효과 포함(문자열 이어붙이지 + 외부 상태 가정)
    private static void parallelReduce() {
        members.parallelStream()
                .map(Member::getName)
                .reduce("", (a, b) -> a + b); // 비효율 + 결합법칙 위배 가능
    }

    private static void parallelReduceSolve() {
        members.parallelStream()
                .map(Member::getName)
                .collect(Collectors.joining());
    }

    private static void parallelStreamIterate() {
        int sum = Stream.iterate(0, i -> i + 1)
                .limit(1_000_000)
                .parallel()
                .reduce(0, Integer::sum);         // 박싱/언박싱 발생, combiner 비용 큼
    }

    private static void parallelStreamIterateSolve() {
        // 범위 스트림은 SIZED/SUBSIZED 분할이 좋아 병렬 친화적
        LongStream.rangeClosed(1, 1_000_000)
                .parallel()
                .sum();
    }

    static class Member {
        private String name;
        private int age;

        public String getName() {
            return this.name;
        }

        public int getAge() {
            return this.age;
        }
    }
}
