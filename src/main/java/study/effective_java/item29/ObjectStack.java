package study.effective_java.item29;

public class ObjectStack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public ObjectStack() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void push(Object o) {
        elements[size++] = o;
    }

    public Object pop() {
        return elements[--size];
    }
}
