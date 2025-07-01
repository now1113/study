package study.effective_java.item41.marker_interface;

public class Member implements Auditable {

    private String name;

    public Member() {
    }

    public Member(String name) {
        this.name = name;
    }
}
