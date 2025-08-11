package study.effective_java.ch06_열거타입과_애너테이션.item39;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ExceptionTestRunner {

    public static void main(String[] args) throws Exception {
        int tests = 0;
        int passed = 0;

        Method[] methods = Sample2.class.getDeclaredMethods();

        for (Method m : methods) {
            ExceptionTest annotation = m.getAnnotation(ExceptionTest.class);

            if(annotation != null) {
                tests++;
                try {
                    m.invoke(null);
                    System.out.println(m + "실패: 예외 없음");
                } catch (InvocationTargetException e) {
                    Throwable cause = e.getCause();
                    if (annotation.value().isInstance(cause)) {
                        passed++;
                    } else {
                        System.out.println(m + " 실패: 예상 예외 아님 " + cause);
                    }
                }
            }
        }
        System.out.printf("성공: %d, 실패: %d%n", passed, tests - passed);
    }
}
