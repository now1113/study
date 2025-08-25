package study.java.example.exception;

import java.util.ArrayDeque;
import java.util.Queue;

public class ControlFlowVsException {

    static void bad() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);

        try {
            while (true) {
                Integer value = queue.remove();
                System.out.println("[bad] polled=" + value);
            }
        } catch (Exception e) {
            System.out.println("[bad] stopped by exception: " + e.getClass().getSimpleName());
        }
    }

    static void good() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        Integer v;

        while ((v = queue.poll()) != null) {
            System.out.println("[good] polled=" + v);
        }
        System.out.println("[good] finished without excpetion");
    }

    public static void main(String[] args) {
        bad();
        good();
    }
}
