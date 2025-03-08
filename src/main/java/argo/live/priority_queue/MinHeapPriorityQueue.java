package argo.live.priority_queue;

import java.util.PriorityQueue;

public class MinHeapPriorityQueue<T extends Comparable>{

    private PriorityQueue<T> queue = new PriorityQueue<>();

    public void enqueue(T item) {
        queue.offer(item);
    }

    public T dequeue() {
        if (queue.isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.poll();
    }

    public T peek() {
        if (queue.isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.peek();
    }
}
