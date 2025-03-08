package argo.live.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeQueue<T> {

    private Deque<T> queue = new ArrayDeque<>();

    public void enqueue(T item) {
        queue.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.removeFirst(); // O(1)
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.getFirst();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public int size() {
        return queue.size();
    }
}
