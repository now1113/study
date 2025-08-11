package study.effective_java.ch06_열거타입과_애너테이션.item38;

public enum ExtendedOperation implements Operation {
    EXP("^") {
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        public double apply(double x, double y) {
            return x % y;
        }
    }
    ;

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }
}
