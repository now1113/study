package study.effective_java.item20;

import java.util.logging.Logger;

public abstract class AbstractHttpService {
    protected final Logger log;

    public AbstractHttpService(Logger log) {
        this.log = log;
    }
}
