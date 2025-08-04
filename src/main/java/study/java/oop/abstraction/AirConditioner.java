package study.java.oop.abstraction;

public class AirConditioner implements RemoteControl{
    @Override
    public void turnOn() {
        System.out.println("AC ON");
    }

    @Override
    public void turnOff() {
        System.out.println("AC OFF");
    }
}
