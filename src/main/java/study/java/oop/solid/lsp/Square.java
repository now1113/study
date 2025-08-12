package study.java.oop.solid.lsp;

public class Square extends Rectangle{
    @Override
    void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}
