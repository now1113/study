package study.effective_java.연습.item78;

public class CounterSynchronized {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
