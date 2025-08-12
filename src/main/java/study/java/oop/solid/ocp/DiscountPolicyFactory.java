package study.java.oop.solid.ocp;

public class DiscountPolicyFactory {
    public static DiscountPolicy getInstance(String type) {
        return switch (type) {
            case "fix" -> new FixDiscountPolicy();
            case "rate" -> new RateDiscountPolicy();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }
}
