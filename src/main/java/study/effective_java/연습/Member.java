package study.effective_java.연습;

import java.util.Objects;

public class Member {
    private String name;
    private MemberGrade grade;
    private int age;

//    Member(String name, int age, MemberGrade grade) {
//        // (나쁜 예) 아무 검증 없음 — 이후 NPE/깨진 상태로 전파
//        this.name = name;
//        this.age = age;
//        this.grade = grade;
//    }

    /**
     * 변경 불가능한 Member를 생성한다.
     *
     * @param name  회원 이름(공백 불가)
     * @param age   나이(0 이상)
     * @param grade 회원 등급(null 불가)
     * @throws NullPointerException name이나 grade가 null인 경우
     * @throws IllegalArgumentException name이 공백이거나 age가 음수인 경우
     */
    public Member(String name, int age, MemberGrade grade) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        if (name.isBlank()) throw new IllegalArgumentException("name must not be blank");

        if (age < 0) throw new IllegalArgumentException("age must not be negative");
        this.age = age;

        this.grade = Objects.requireNonNull(grade, "grade must not be null");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MemberGrade getGrade() {
        return grade;
    }

    public void setGrade(MemberGrade grade) {
        this.grade = grade;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
