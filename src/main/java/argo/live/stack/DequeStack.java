package argo.live.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeStack<T> {

    private Deque<T> stack = new ArrayDeque<>();

    public void push(T item) {
        stack.push(item);
    }

    public T pop() {
        if(stack.isEmpty()) throw new RuntimeException("스택이 비어있음");
        return stack.removeLast();
    }

    public T peek() {
        if(stack.isEmpty()) throw new RuntimeException("스택이 비어있음");
        return stack.getLast();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
