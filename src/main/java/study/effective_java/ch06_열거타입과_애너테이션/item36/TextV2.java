package study.effective_java.ch06_열거타입과_애너테이션.item36;

import java.util.EnumSet;

public class TextV2 {

    public enum Style {
        BOLD, ITALIC, UNDERLINE, STRIKETHROUGH
    }

    public void applyStyles(EnumSet<Style> styles) {
        //
    }
}
