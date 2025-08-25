package study.java.example.oop.polymorphism;

public class OrderService {
    private final DiscountPolicy discountPolicy;

    public OrderService(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }

    public int finalPrice(int price) {
        return price - discountPolicy.discount(price);
    }
}
