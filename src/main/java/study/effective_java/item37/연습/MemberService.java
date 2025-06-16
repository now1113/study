package study.effective_java.item37.연습;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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

}
