package study.effective_java.연습.item47;

import study.effective_java.연습.Member;
import study.effective_java.연습.MemberGrade;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    // 무조건 Stream으로 돌려주면 재사용/탐색 불가, 자원 닫기 이슈 가능
    public Stream<Member> findAllStreamMembers() {
        // 클라이언트는 collect부터 강요됨
        List<Member> members = new ArrayList<>();
        return members.stream();
    }

    public List<Member> findAllMembers() {
        List<Member> members = new ArrayList<>();
        return List.copyOf(members);
    }

    // DB 커서 기반 - 반드시 try-with-resources로 닫게 설계/문서화
    public Stream<Member> streamByGrade(MemberGrade memberGrade) {
        // JPA/Hibernate의 ScrollableResult, JDBC ResultSet 등으로부터 Stream 구성했다고 가정
        return memberRepository.streamByGrade(memberGrade); // 문서에 close 필요 남기기
    }
}
