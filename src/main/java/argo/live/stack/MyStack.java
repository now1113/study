package argo.live.stack;

import java.util.ArrayList;
import java.util.List;

public class MyStack<T> {

    private List<T> stack;

    // 스택을 초기화
    public MyStack() {
        this.stack = new ArrayList<>();
    }

    // 스택에 새로운 요소 추가
    public void push(T item) {
        stack.add(item);
    }

    // 스택의 가장 위에 있는 요소를 제거하고 반환
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException("스택이 비어 있습니다.");
        }
        return stack.remove(stack.size() - 1);
    }

    // 스택의 가장 위에 있는 요소를 반환하지만 제거하지는 않음.
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException("스택이 비어 있습니다.");
        }
        return stack.get(stack.size() - 1);
    }

    // 스택이 비어있는지 확인
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    // 스택의 요소 개수를 반환
    public int size() {
        return stack.size();
    }

    // 스택의 모든 요소를 문자열로 반환
    @Override
    public String toString() {
        return stack.toString();
    }
}
