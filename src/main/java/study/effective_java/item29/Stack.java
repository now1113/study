package study.effective_java.item29;

public class Stack<E> {
    private E[] elements;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public Stack() {
        elements = (E[]) new Object[10]; // 제네릭 타입으로 직접 배열을 생성할 수 없으므로 형변환 필요
    }
    public void push(E e) {
        elements[size++] = e;
    }
    public E pop() {
        return elements[--size];
    }
}
