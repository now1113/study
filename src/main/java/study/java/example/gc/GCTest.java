package study.java.example.gc;

public class GCTest {

    private static final int _1MB = 1024 * 1024;

    /**
     *  Edit Configurations -> VM options -> -XX:+printGC -Xms50m -Xmx50m
     */
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start GC Test");

        // 메모리 점유: 총 40MB 정도
        byte[] block1 = new byte[4 * _1MB];
        byte[] block2 = new byte[4 * _1MB];
        byte[] block3 = new byte[4 * _1MB];
        byte[] block4 = new byte[4 * _1MB];
        byte[] block5 = new byte[4 * _1MB];

        System.out.println("Memory blocks allocated");

        // 강제로 null 처리 후 GC 유도
        block1 = null;
        block2 = null;
        System.gc();
        System.out.println("Called System.gc()");

        // 잠깐 대기 후 GC 로그 확인
        Thread.sleep(2000);

        System.out.println("Done");
    }
}
