package study.effective_java.연습.item53;

import study.effective_java.연습.Member;

public class MemberService {

    static void save(Member... ms) {
        System.out.println("save1");
    }

    static void save(String path, Member... ms) {
        System.out.println("save2");
    }

    public static void main(String[] args) {
        save("data");
        save();
    }
}
