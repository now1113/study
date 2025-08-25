package study.java.example.oop.solid.ocp;


public class DiscountService {

    public int discount(String type, int price) {
        if (type.equals("fix")) {
            return price - 1000;
        } else if (type.equals("rate")) {
            return price * 90 / 100;
        }
        return price;
    }

    public int discountV2(String type, int price) {
        DiscountPolicy policy = DiscountPolicyFactory.getInstance(type);
        return policy.discount(price);
    }
}
