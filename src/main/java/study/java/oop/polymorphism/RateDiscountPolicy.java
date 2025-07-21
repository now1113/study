package study.java.oop.polymorphism;

public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return price * 10 / 100;
    }
}
