package study.effective_java.ch06_열거타입과_애너테이션.item41.marker_annotation;

public class Main {

    public static void main(String[] args) {

    }

    public static void deleteIfDeletable(Object o) {
        if (o.getClass().isAnnotationPresent(Deletable.class)) {
            // do delete
        }
    }
}
