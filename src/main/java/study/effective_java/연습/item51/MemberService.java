package study.effective_java.연습.item51;

import study.effective_java.연습.Member;
import study.effective_java.연습.MemberGrade;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class MemberService {

    private enum Scope {
        ACTIVE_ONLY, INCLUDE_INACTIVE
    }

    // 무엇을 하는지 모호 + boolean 플래그로 의미가 갈림
    public List<Member> process(MemberGrade memberGrade, boolean includeInactive) {
        return null;
    }

    // 역할을 분명히 분리
    public List<Member> findActiveByGrade(MemberGrade memberGrade) {
        return null;
    }
    public List<Member> findAllByGrade(MemberGrade memberGrade) {
        return null;
    }
    // enum으로 의도 명확화
    public List<Member> findByGrade(MemberGrade memberGrade, Scope scope) {
        return null;
    }

    // 파라미터 7개, 가독성/호출 실수 위험
    public List<Member> search(MemberGrade memberGrade,
                               Integer minAge,
                               Integer maxAge,
                               String city,
                               String keyword,
                               int page,
                               int size) {
        return null;
    }
    // 시그니쳐가 단순해짐
    public List<Member> search(MemberSearchCriteria memberSearchCriteria) {
        return null;
    }

    // 구체 컬렉션에 종속
    public void registerAll(ArrayList<Member> batch) {

    }

    public void registerAll(List<Member> batch) {

    }

    // 문자열로 날짜/기간/경로를 받으면 형식, 시간대 검증 지옥
    public List<Member> findJoinedBetween(String from, String to, String tz) {
        return null;
    }
    // 의미 있는 타입으로 받기
    public List<Member> findJoinedBetween(LocalDate from,  LocalDate to, ZoneId tz) {
        return null;
    }

    // 둘 다 String -> 호출부에서 바꿔 넣어도 컴파일 OK, 런타임 버그
    public void reanme(String oldName, String newName) {

    }

    // 전용 타입 or 메서드명으로 의미를 강하게, 또는 메서드 분리하기
    public void rename(MemberName oldName, MemberName newName) {

    }


}
