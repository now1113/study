package study.java.example.oop.solid.lsp;

public class Square extends Rectangle{
    @Override
    void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
}
