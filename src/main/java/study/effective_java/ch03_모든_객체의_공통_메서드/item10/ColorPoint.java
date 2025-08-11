package study.effective_java.ch03_모든_객체의_공통_메서드.item10;

public class ColorPoint extends Point{

    private final Point point;
    private final String color;

    public ColorPoint(int x, int y, Point point, String color) {
        super(x, y);
        this.point = point;
        this.color = color;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ColorPoint)) return false;
        ColorPoint cp = (ColorPoint) obj;
        return point.equals(cp.point) && color.equals(cp.color);
    }

    //    private final String color;
//
//    public ColorPoint(int x, int y, String color) {
//        super(x, y);
//        this.color = color;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Point)) {
//            return false;
//        }
//        if (!(obj instanceof ColorPoint)) {
//            return super.equals(obj);
//        }
//
//        // ColorPoint와 비교할 때는 색상까지 비교
//        ColorPoint cp = (ColorPoint) obj;
//        return super.equals(cp) && cp.color.equals(color);
//    }
}
