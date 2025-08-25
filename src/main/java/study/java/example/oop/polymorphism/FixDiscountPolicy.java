package study.java.example.oop.polymorphism;

public class FixDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return 1000;
    }
}
