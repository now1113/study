package study.effective_java.연습.item78;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic {
    private final AtomicLong count = new AtomicLong();

    public void increment() {
        count.incrementAndGet();
    }

    public long getCount() {
        return count.get();
    }
}
