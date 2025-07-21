package study.effective_java.item44;

import java.util.function.*;

public class Main {

    public static void main(String[] args) {

        UnaryOperator<String> upper = String::toUpperCase;
        System.out.println(upper.apply("hello")); // HELLO

        BinaryOperator<Integer> add = (x, y) -> x + y;
        System.out.println(add.apply(3, 5));  // 8

        Function<String, Integer> lengthFunction = String::length;
        System.out.println(lengthFunction.apply("effective")); // 9

        Supplier<Double> randomSupplier = Math::random;
        System.out.println(randomSupplier.get());   // 무작위 숫자 반환

        Consumer<String> printer = System.out::println;
        printer.accept("Hello");    // Hello

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test(""));   // true

        IntBinaryOperator multiply = (x, y) -> x * y;
        System.out.println(multiply.applyAsInt(3, 4));
    }
}
