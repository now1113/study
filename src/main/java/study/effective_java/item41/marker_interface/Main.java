package study.effective_java.item41.marker_interface;

public class Main {

    public static void main(String[] args) {
        Member member = new Member();
        audit(member);

//        Users users = new Users();
//        audit(users);
    }

    public static <T extends Auditable> void audit(T entity) {
        // Auditable만 허용됨
    }
}
