package study.effective_java.연습.item75;

public class SafeIntList {

    private final int[] values;

    public SafeIntList(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("size must be >= 0, but was " + size);
        }
        this.values = new int[size];
    }

    public int get(int index) {
        if (index < 0 || index >= values.length) {
            throw new InvalidIndexException(index, values.length);
        }
        return values[index];
    }

    public void set(int index, int value) {
        if (index < 0 || index >= values.length) {
            throw new InvalidIndexException(index, values.length);
        }
        values[index] = value;
    }

    public int size() {
        return values.length;
    }
}
