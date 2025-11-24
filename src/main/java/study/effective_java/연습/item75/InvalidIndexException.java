package study.effective_java.연습.item75;

public class InvalidIndexException extends RuntimeException {

    private final int index;
    private final int size;

    public InvalidIndexException(int index, int size) {
        super(buildMessage(index, size));
        this.index = index;
        this.size = size;
    }

    private static String buildMessage(int index, int size) {
        return "Index out of range. index=" + index + ", size=" + size;
    }

    public int getIndex() {
        return index;
    }

    public int getSize() {
        return size;
    }
}
