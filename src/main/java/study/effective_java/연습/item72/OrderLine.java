package study.effective_java.연습.item72;

import java.util.Objects;

public class OrderLine {
    private final String productId;
    private final int quantity;

    public OrderLine(String productId, int quantity) {
        this.productId = Objects.requireNonNull(productId, "productId must not be null");
        if (productId.isBlank()) {
            throw new IllegalArgumentException("productId must not be blank");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("quantity must not be negative");
        }
        this.quantity = quantity;
    }
}
