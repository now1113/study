package study.effective_java.연습.item49;

import study.effective_java.연습.Member;
import study.effective_java.연습.MemberGrade;

import java.util.List;
import java.util.Objects;

public class MemberService {

    /**
     * 주어진 등급과 나이 범위 [minAgeInclusive, maxAgeExclusive)에 해당하는 회원 목록을 반환한다.
     *
     * @param members        소스 리스트(null 불가)
     * @param grade          대상 등급(null 불가)
     * @param minAgeInclusive 최소 나이(0 이상)
     * @param maxAgeExclusive 최대 나이의 배타적 경계(minAgeInclusive보다 커야 함)
     * @return 필터링된 회원 목록(never null)
     * @throws NullPointerException members나 grade가 null인 경우
     * @throws IllegalArgumentException minAgeInclusive가 0 미만이거나,
     *                                  maxAgeExclusive가 minAgeInclusive 이하인 경우
     */
    public List<Member> findByGradeAndAgeRange(List<Member> members,
                                               MemberGrade grade,
                                               int minAgeInclusive,
                                               int maxAgeExclusive) {
        Objects.requireNonNull(members, "members must not be null");
        Objects.requireNonNull(grade, "grade must not be null");

        if (minAgeInclusive < 0) throw new IllegalArgumentException("minAgeInClusive must not be negative");
        if (maxAgeExclusive <= minAgeInclusive) {
            throw new IllegalArgumentException("maxAgeInClusive must be greater than minAgeInClusive");
        }

        return members.stream()
                .filter(m -> m.getGrade() == grade)
                .filter(m -> m.getAge() >= minAgeInclusive && m.getAge() < maxAgeExclusive)
                .toList();
    }

    private void memberAssert(Member member, int age) {
        assert member != null;
        assert age != 0;
    }

    public static <T> List<T> safeSubList(List<T> list, int from, int to) {
        Objects.requireNonNull(list, "list must not be null");
        Objects.checkFromToIndex(from, to, list.size());
        return list.subList(from, to);
    }

}
