package study.effective_java.연습.item65;

final class Plugins {
    static GPlugin create(String fqcn) {
        try {
            // asSubClass로 GPlugin의 하위 타입만 허용
            Class<? extends GPlugin> cl = Class.forName(fqcn).asSubclass(GPlugin.class);
            return cl.getDeclaredConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new IllegalArgumentException("플러그인 로딩 실패: " + fqcn, e);
        }
    }
}
