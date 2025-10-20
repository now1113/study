package study.effective_java.연습.item65;

import java.lang.reflect.Method;

public class BadAllReflection {
    public static void main(String[] args) throws Exception {
        // 외부 설정에서 온다고 가정
        String fqcn = UpperPlugin.class.getName();
        Class<?> cl = Class.forName(fqcn);
        Object obj = cl.getDeclaredConstructor().newInstance();

        // 매 호출마다 리플렉션(느림) + 문자열 의존(타입 안전성 없음)
        Method run = cl.getMethod("run", String.class);
        String out = (String) run.invoke(obj, "hello");
        System.out.println(out);
    }
}
