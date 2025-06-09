package study.effective;

public class Main {
    public static void main(String[] args) {
        ObjectStack objectStack = new ObjectStack();
        objectStack.push("hello");
        Integer i = (Integer) objectStack.pop(); // ClassCastException
    }
}
