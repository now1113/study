package study.effective_java.ch02_객체_생성과_파괴.item04;

public class MathUtils {

    private MathUtils() {
        //
        throw new AssertionError("유틸리티 클래스이므로 인스턴스를 생성할 수 없습니다.");
    }

    public static int add(int a, int b) {
        //
        return a + b;
    }

}
