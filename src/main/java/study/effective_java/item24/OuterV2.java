package study.effective_java.item24;

public class OuterV2 {
    private int outerValue = 10;

    static class StaticInner {
        public void print() {
            System.out.println("static inner class");
        }
    }
}
