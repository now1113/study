package study.effective_java.ch06_열거타입과_애너테이션.item36;

public class Text {
    public static final int STYLE_BOLD = 1 << 0;    // 1
    public static final int STYLE_ITALIC = 1 << 1;  // 2
    public static final int STYLE_UNDERLINE = 1 << 2;   // 4
    public static final int STYLE_STRIKETHROUGH = 1 << 3;   // 8

    public void applyStyles(int styles) {
        //
    }
}
