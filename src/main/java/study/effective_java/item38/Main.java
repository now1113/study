package study.effective_java.item38;

import java.util.Collection;
import java.util.EnumSet;

public class Main {

    public static void main(String[] args) {
        printResult(2, 4, EnumSet.allOf(BasicOperation.class));
        printResult(2, 4, EnumSet.allOf(ExtendedOperation.class));
    }

    public static void printResult(double x, double y, Collection<? extends Operation> ops) {
        for (Operation op : ops) {
            System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
        }
    }
}
