package study.java.example.oop.solid.ocp;

public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(int price) {
        return 0;
    }
}
