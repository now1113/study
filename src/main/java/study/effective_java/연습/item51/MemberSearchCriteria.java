package study.effective_java.연습.item51;

import study.effective_java.연습.MemberGrade;

public final class MemberSearchCriteria {
    private final MemberGrade memberGrade;
    private final Integer minAge;
    private final Integer maxAge;
    private final String city;
    private final String keyword;
    private final int page;
    private final int size;

    public MemberSearchCriteria(MemberGrade memberGrade, Integer minAge, Integer maxAge, String city, String keyword, int page, int size) {
        this.memberGrade = memberGrade;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.city = city;
        this.keyword = keyword;
        this.page = page;
        this.size = size;
    }
}
