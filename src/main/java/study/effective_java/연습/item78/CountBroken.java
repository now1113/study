package study.effective_java.연습.item78;

public class CountBroken {
    private int count;

    public void increment() {
        count++;    // read-modify-write
    }

    public int getCount() {
        return count;
    }
}
