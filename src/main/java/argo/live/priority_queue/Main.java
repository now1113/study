package argo.live.priority_queue;

public class Main {

    public static void main(String[] args) {

        MinHeapPriorityQueue<Integer> pq = new MinHeapPriorityQueue<>();

        pq.enqueue(10);
        pq.enqueue(3);
        pq.enqueue(1);

        System.out.println("peek: " + pq.peek()); // 1 (최소값)
        System.out.println("dequeue: " + pq.dequeue()); // 1
        System.out.println("dequeue: " + pq.dequeue()); // 3
        System.out.println("dequeue: " + pq.dequeue()); // 10
    }
}
