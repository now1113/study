package argo.live.queue;

import java.util.LinkedList;

public class LinkedListQueue<T> {

    private LinkedList<T> queue = new LinkedList<>();

    public void enqueue(T item) {
        queue.addLast(item);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.removeFirst(); // 맨 앞 요소 제거 (O(1))
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
