package study.effective_java.ch04_클래스와_인터페이스.item17;

import java.util.Date;

public final class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        // 방어적 복사
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());

        if (this.start.after(this.end)) {
            throw new IllegalArgumentException("start must be before end");
        }
    }

    public Date start() {
        // 방어적 복사
        return new Date(start.getTime());
    }

    public Date end() {
        // 방어적 복사
        return new Date(end.getTime());
    }
}
