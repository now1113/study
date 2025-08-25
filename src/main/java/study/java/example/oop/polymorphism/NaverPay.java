package study.java.example.oop.polymorphism;

public class NaverPay implements PaymentGateway {
    @Override
    public void pay(int amount) {
        System.out.println("네이버페이 결제:" + amount);
    }
}
