package study.effective_java.ch06_열거타입과_애너테이션.item38;

public enum BasicOperation implements Operation {
    PLUS("+") {
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y) {
            return x - y;
        }
    }
    ;
    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

}
