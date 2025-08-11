package study.effective_java.ch06_열거타입과_애너테이션.item39;

import java.lang.reflect.Method;

public class TestRunner {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Class<?> testClass = SampleTest.class;

        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                tests++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (Exception e) {
                    Throwable cause = e.getCause();
                    System.out.println(m.getName() + " 실패: " + cause);
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
