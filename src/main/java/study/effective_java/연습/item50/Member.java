package study.effective_java.연습.item50;

import study.effective_java.연습.MemberGrade;

import java.util.List;
import java.util.Objects;

public final class Member {
    private final String name;
    private final int age;
    private final MemberGrade memberGrade;
    private final Address address;
    private final List<String> roles;

    public Member(String name, int age, MemberGrade memberGrade, Address address, List<String> roles) {
        this.name = Objects.requireNonNull(name);
        if (age < 0) throw new IllegalArgumentException("age >= 0");
        this.age = age;
        this.memberGrade = Objects.requireNonNull(memberGrade);

        this.address = copyOf(address);
        validate(this.address);

        this.roles = List.copyOf(Objects.requireNonNull(roles));
    }

    private static Address copyOf(Address src) {
        Objects.requireNonNull(src);
        Address x = new Address();
        x.setCity(src.getCity());
        x.setStreet(src.getStreet());
        return x;
    }

    private static void validate(Address address) {
        if (address.getCity() == null || address.getCity().isBlank()) {
            throw new IllegalArgumentException("city required");
        }
    }

    public Address getAddress() {
        return copyOf(address);
    }

    public List<String> getRoles() {
        return roles;
    }

}
