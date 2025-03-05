package argo.live.stack;

public class StackExample {

    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("스택 상태" + stack);

    }
}
