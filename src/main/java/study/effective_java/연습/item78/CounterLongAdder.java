package study.effective_java.연습.item78;

import java.util.concurrent.atomic.LongAdder;

public class CounterLongAdder {
    private final LongAdder count = new LongAdder();

    public void increment() {
        count.increment();
    }

    public long getCount() {
        return count.sum();
    }
}
