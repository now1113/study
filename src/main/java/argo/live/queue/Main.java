package argo.live.queue;

public class Main {

    public static void main(String[] args) {
        DequeQueue<Integer> queue = new DequeQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("peek: " + queue.peek()); // 1
        System.out.println("dequeue: " + queue.dequeue()); // 1

        System.out.println("peek: " + queue.peek()); // 2
        System.out.println("dequeue: " + queue.dequeue()); // 2

        System.out.println("peek: " + queue.peek()); // 3
        System.out.println("dequeue: " + queue.dequeue()); // 3

        System.out.println("isEmpty: " + queue.isEmpty()); // true
    }
}
