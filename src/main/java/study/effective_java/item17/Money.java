package study.effective_java.item17;

public class Money {
    private int amount;
    public Money(int amount) {
        this.amount = amount;
    }
    public Money add(int value) {
        return new Money(this.amount + value);
    }
}
