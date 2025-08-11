package study.effective_java.ch04_클래스와_인터페이스.item17;

public class Money {
    private int amount;
    public Money(int amount) {
        this.amount = amount;
    }
    public Money add(int value) {
        return new Money(this.amount + value);
    }
}
