package study.effective;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private Object[] elements;
    private int size = 0;

    public Stack(int capacity) {
        elements = new Object[capacity];
    }

    public void push(Object object) {
        elements[size++] = object;
        printStack();
    }

    public Object pop() {
        if (size == 0) throw new EmptyStackException();
        Object obj = elements[--size];  // 메모리 누수 발생 가능
        printStack();
        return obj;
    }


    public Object popV2() {
        if (size == 0) throw new EmptyStackException();
        Object obj = elements[--size];
        elements[size] = null;
        printStack();
        return obj;
    }

    private void printStack() {
        System.out.println("스택 상태 (size=" + size + "):" + Arrays.toString(elements));
    }
}
