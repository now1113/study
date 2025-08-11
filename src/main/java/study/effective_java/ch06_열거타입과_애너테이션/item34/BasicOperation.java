package study.effective_java.ch06_열거타입과_애너테이션.item34;

public enum BasicOperation implements Operation {
    PLUS   { public double apply(double x, double y) { return x + y; } },
    MINUS  { public double apply(double x, double y) { return x - y; } },
    TIMES  { public double apply(double x, double y) { return x * y; } },
    DIVIDE { public double apply(double x, double y) { return x / y; } };
}
