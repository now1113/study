package argo.live.queue;

import java.util.ArrayList;
import java.util.List;

public class ArrayListQueue<T> {

    private List<T> queue = new ArrayList<>();

    // 큐에 데이터를 추가
    public void enqueue(T item) {
        queue.add(item);
    }

    // 큐의 첫 번째 요소를 제거하고 반환
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("큐가 비어있음");
        }
        return queue.remove(0);
    }

    public boolean isEmpty() {
        //
        return queue.isEmpty();
    }
}
