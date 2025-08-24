package study.effective_java.연습.item53;

import study.effective_java.연습.Level;
import study.effective_java.연습.Member;

public class NotifyService {

    public void notify(Level level, Member first, Member... others) {
        send(level, first);
        for (Member m : others) {
            send(level, m);
        }
    }

    public void send(Level level, Member member) {

    }
}
