package study.effective_java.ch03_모든_객체의_공통_메서드.item10;

public class Point {

    protected final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) return false;
        Point p = (Point) obj;
        return p.x == x && p.y == y;
    }
}
