package study.effective_java.연습.item65;

public class GUpperPlugin implements GPlugin{
    @Override
    public String run(String in) {
        return in.toUpperCase();
    }
}
