package study.java.example.oop.inheritance;

public class Square extends Rectangle {

    @Override
    public void setWidth(int w) {
        super.setWidth(w);
        super.setHeight(w); // 가로 == 세로로 강제
    }

    @Override
    public void setHeight(int h) {
        super.setHeight(h);
        super.setWidth(h); // 세로 == 가로로 강제
    }
}
