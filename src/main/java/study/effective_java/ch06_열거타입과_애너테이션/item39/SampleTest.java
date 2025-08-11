package study.effective_java.ch06_열거타입과_애너테이션.item39;

public class SampleTest {

    @Test
    public static void successTest() {
        // 통과
    }

    @Test
    public static void failTest() {
        throw new RuntimeException("Fail");
    }

    public static void notATest() {}
}
