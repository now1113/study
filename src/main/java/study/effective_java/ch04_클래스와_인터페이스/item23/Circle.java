package study.effective_java.ch04_클래스와_인터페이스.item23;

public class Circle extends Figure{

    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * (radius * radius);
    }
}
