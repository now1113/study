package study.java.ex;

public class GCRootExample {
    private static GCRootExample staticField;

    public static void main(String[] args) {
        GCRootExample localVar = new GCRootExample();   // Local 변수 -> stack Root
        staticField = new GCRootExample();  // Static 필드 -> GC Root
        GCRootExample obj = new GCRootExample();    // 이후 참조 끊기면 GC 대상

        obj = null; // 이 객체는 Root에서 도달 불가 -> GC 대상
    }
}
