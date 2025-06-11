package study.effective_java.item24;

public class Outer {
    private int outerValue = 10;

    class Inner {
        public void printOuterValue() {
            // 암묵적으로 Outer.this 참조
            System.out.println(outerValue);
        }
    }
}
