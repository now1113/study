package study.effective_java.ch02_객체_생성과_파괴.item07;


public class Main {

    private static final ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static void main(String[] args) {

        Stack stack = new Stack(5);
        stack.push("A");
        stack.push("B");
        stack.push("C");

//        stack.pop();
//        stack.pop();

        stack.popV2();
        stack.popV2();
    }
}
