package study.java.example.oop.polymorphism;

public class KakaoPay implements  PaymentGateway {
    @Override
    public void pay(int amount) {
        System.out.println("카카오페이 결제:" + amount);
    }
}
