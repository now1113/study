package study.effective_java.연습.item47;

import study.effective_java.연습.Member;
import study.effective_java.연습.MemberGrade;

import java.util.List;
import java.util.stream.Stream;

public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    public List<Member> findAllStreamMembers() {
        Stream<Member> allMembers = memberService.findAllStreamMembers();

        // Stream은 한 번만 사용이 가능
//        long count = allMembers.count();

        // Stream을 바로 JSON으로 직렬화하지 못하니 바꿔줘야함.
        try (Stream<Member> members = allMembers) {
            return allMembers.toList();
        }
    }

    public void findAllMembers() {
        List<Member> all = memberService.findAllMembers();
        List<Integer> names = all.stream()
                .map(Member::getAge)
                .toList();
    }

    public void streamByGrade() {
        try (Stream<Member> s = memberService.streamByGrade(MemberGrade.GOLD)) {
            long count = s.filter(m -> m.getAge() >= 30).count();
        }
    }
}
