package study.effective;

public class FigureBad {

    enum Shape { RECTANGLE, CIRCLE }

    final Shape shape;

    // RECTANGLE 일 때 사용
    double length;
    double width;

    // CIRCLE 일 때 사용
    double radius;

    // 생성자: 사각형
    FigureBad(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    // 생성자: 원
    FigureBad(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    double area() {
        switch (shape) {
            case RECTANGLE : return length * width;
            case CIRCLE: return Math.PI * (radius * radius);
            default: throw new AssertionError(shape);
        }
    }

}
