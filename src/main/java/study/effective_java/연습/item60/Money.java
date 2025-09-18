package study.effective_java.연습.item60;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Money {
    private long amount;

    public Money(long amount) {
        this.amount = amount;
    }

    public static Money from(long won) {
        if (won < 0) {
            throw new IllegalArgumentException("negative money");
        }
        return new Money(won);
    }

    public Money plus(Money other) {
        return new Money(this.amount + other.amount);
    }

    public Money multiplyPercent(BigDecimal percent, RoundingMode mode) {
        BigDecimal base = BigDecimal.valueOf(this.amount);
        long won = base.multiply(percent)
                .setScale(0, mode)
                .longValueExact();

        return new Money(won);
    }

    public int compareTo(Money other) {
        return Long.compare(this.amount, other.amount);
    }
}
