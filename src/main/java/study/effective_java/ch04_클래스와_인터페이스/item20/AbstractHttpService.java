package study.effective_java.ch04_클래스와_인터페이스.item20;

import java.util.logging.Logger;

public abstract class AbstractHttpService {
    protected final Logger log;

    public AbstractHttpService(Logger log) {
        this.log = log;
    }
}
