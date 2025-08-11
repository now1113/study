package study.effective_java.ch05_제네릭.item29;

public class Main {
    public static void main(String[] args) {
        ObjectStack objectStack = new ObjectStack();
        objectStack.push("hello");
        Integer i = (Integer) objectStack.pop(); // ClassCastException
    }
}
