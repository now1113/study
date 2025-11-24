package study.effective_java.연습.item75;

public class InvalidIndexDemo {
    void main() {
        SafeIntList list = new SafeIntList(5);

        try {
            list.set(10, 42);
        } catch (InvalidIndexException e) {
            System.err.println("Error message  : " + e.getMessage());

            System.err.println("Failing index : " +e.getIndex());
            System.err.println("Collections size: " + e.getSize());
        }
    }
}
