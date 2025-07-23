package study.effective_java.연습.item45;

import study.effective_java.연습.Member;
import study.effective_java.연습.MemberGrade;

import java.util.ArrayList;
import java.util.List;

public class Example {

    public void item45Example() {
        List<Member> members = new ArrayList<>();
        List<String> result = new ArrayList<>();

        members.stream()
                .filter(m -> m.getAge() > 20)
                .forEach(m -> result.add(m.getName())); // 외부 상태 변화는 위험

        List<String> result2 = members.stream()
                .filter(m -> m.getAge() > 20)
                .map(Member::getName)
                .toList();

        int count = 0;
        for (Member member : members) {
            if (member.getGrade() == MemberGrade.BRONZE) {
                count++;
                System.out.println("BRONZE 등급 회원 :" + member.getName());
            }
        }
    }
}
