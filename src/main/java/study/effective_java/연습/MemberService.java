package study.effective_java.연습;

import study.effective_java.연습.item44.MemberFilter;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemberService {
    // badCase
    public int[] countLoginByGrade(List<Member> members) {
        int[] counts = new int[MemberGrade.values().length];

        for (Member member : members) {
            counts[member.getGrade().ordinal()]++;
        }

        return counts;  // return [5, 10, 3, 1]
    }

    // goodCase
    public Map<MemberGrade, Integer> countLoginsByGrade(List<Member> members) {
        EnumMap<MemberGrade, Integer> counts = new EnumMap<>(MemberGrade.class);

        // 초기값 세팅
        for (MemberGrade grade : MemberGrade.values()) {
            counts.put(grade, 0);
        }

        // 등급 별로 카운팅
        for (Member member : members) {
            MemberGrade grade = member.getGrade();
            counts.put(grade, counts.get(grade) + 1);
        }

        return counts;  // return {BRONZE=5, SILVER=10, GOLD=3, PLATINUM=1}
    }

    // badCase
    public Map<MemberGrade, Long> countByGradeWithFilter(List<Member> members, MemberFilter filter) {
        Map<MemberGrade, Long> result = new EnumMap<>(MemberGrade.class);
        for (MemberGrade grade : MemberGrade.values()) {
            result.put(grade, 0L);
        }
        for (Member member : members) {
            if (filter.test(member)) {
                result.put(member.getGrade(), result.get(member.getGrade()) + 1);
            }
        }
        return result;
    }

    // goodCase
    public Map<MemberGrade, Long> countByGradeWithPredicate(List<Member> members, Predicate<Member> predicate) {
        return members.stream()
                .filter(predicate)
                .collect(Collectors.groupingBy(
                        Member::getGrade,
                        () -> new EnumMap<>(MemberGrade.class),
                        Collectors.counting()
                ));
    }
}
