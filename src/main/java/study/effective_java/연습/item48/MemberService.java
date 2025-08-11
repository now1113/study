package study.effective_java.연습.item48;

import study.effective_java.연습.Member;
import study.effective_java.연습.MemberGrade;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MemberService {

    // 순차/병렬 모두 안전
    public Map<MemberGrade, Long> getMemberMap() {
        List<Member> members = new ArrayList<>();

        return members.parallelStream()
                .collect(Collectors.groupingBy(
                        Member::getGrade,
                        () -> new EnumMap<>(MemberGrade.class),
                        Collectors.counting()
                ));
    }

    // encounter order 불필요 -> 병렬 집계의 유리
    public Map<MemberGrade, Long> getMemberMapByConcurrent() {
        List<Member> members = new ArrayList<>();

        return members.parallelStream()
                .unordered()
                .collect(Collectors.groupingByConcurrent(
                        Member::getGrade,
                        ConcurrentHashMap::new,
                        Collectors.counting()
                ));
    }
}
