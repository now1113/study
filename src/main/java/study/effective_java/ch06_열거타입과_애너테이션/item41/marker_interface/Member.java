package study.effective_java.ch06_열거타입과_애너테이션.item41.marker_interface;

public class Member implements Auditable {

    private String name;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }
}
