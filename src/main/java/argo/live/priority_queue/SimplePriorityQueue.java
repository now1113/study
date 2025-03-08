package argo.live.priority_queue;

import java.util.ArrayList;
import java.util.List;

public class SimplePriorityQueue<T extends Comparable<T>> {

    private List<T> queue = new ArrayList<>();

    public void enqueue(T item) {
        queue.add(item);
        queue.sort(null);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.remove(0);
    }

    public T peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.get(0);
    }
}
