package study.effective_java.연습.item73;

import study.effective_java.연습.Member;

import java.sql.SQLException;


public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getMember(String id) throws SQLException {
        // DB 구현 세부사항인 SQLException이 service API에 그대로 노출됨
        return memberRepository.badFindById(id);
    }

    public Member getMemberV2(String id) {
        try {
            return memberRepository.findById(id);
        } catch (RepositoryException e) {
            throw new MemberServiceException("Failed to load member: " + id, e);
        }

    }
}
