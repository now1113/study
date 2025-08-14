package study.effective_java.연습.item50;

import study.effective_java.연습.MemberGrade;

import java.util.List;

public class BadMember {
    private final String name;
    private final int age;
    private final MemberGrade memberGrade;
    private final Address address;
    private final List<String> roles;

    public BadMember(String name, int age, MemberGrade memberGrade, Address address, List<String> roles) {
        this.name = name;
        this.age = age;
        this.memberGrade = memberGrade;
        this.address = address;             // 그대로 저장 (취약)
        this.roles = roles;                 // 그대로 저장 (취약)
    }

    public Address getAddress() {
        return address;
    }

    public List<String> getRoles() {
        return roles;
    }
}
