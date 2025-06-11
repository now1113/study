package study.effective_java.item29;

public class Main {
    public static void main(String[] args) {
        ObjectStack objectStack = new ObjectStack();
        objectStack.push("hello");
        Integer i = (Integer) objectStack.pop(); // ClassCastException
    }
}
