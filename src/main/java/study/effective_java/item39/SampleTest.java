package study.effective_java.item39;

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
