package study.java.example.oop.abstraction;

public class TV implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("TV ON");
    }

    @Override
    public void turnOff() {
        System.out.println("TV OFF");
    }
}
