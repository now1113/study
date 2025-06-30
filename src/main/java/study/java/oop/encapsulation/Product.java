package study.java.oop.encapsulation;

public class Product {
    private int price;

    public void setPrice(int price) {
        this.price = price;
    }

    public void increasePrice(int delta) {
        if (delta < 0) throw new IllegalArgumentException("가격 증가량은 0 이상이어야 합니다.");
        this.price += delta;
    }
}
