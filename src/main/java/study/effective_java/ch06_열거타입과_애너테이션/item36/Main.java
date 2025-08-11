package study.effective_java.ch06_열거타입과_애너테이션.item36;

import java.util.EnumSet;

import static study.effective_java.ch06_열거타입과_애너테이션.item36.TextV2.*;

public class Main {

    public static void main(String[] args) {
        Text text = new Text();
        text.applyStyles(Text.STYLE_BOLD | Text.STYLE_ITALIC);

        TextV2 tv = new TextV2();
        tv.applyStyles(EnumSet.of(Style.BOLD, Style.ITALIC));
    }
}
