package study.effective_java.연습.item65;

public class UpperPlugin implements Plugin {
    @Override
    public String run(String in) {
        return in.toUpperCase();
    }
}

