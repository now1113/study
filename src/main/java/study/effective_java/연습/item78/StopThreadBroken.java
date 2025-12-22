package study.effective_java.연습.item78;

public class StopThreadBroken {
    private static boolean stopRequested;

    void main() throws InterruptedException {
        Thread background = new Thread(() -> {
            long i = 0;
            while (!stopRequested) {
                i++;
            }
            System.out.println("stopped: " + i);
        });

        background.start();

        Thread.sleep(1000);
        stopRequested = true;   // 다른 스레드가 이 변경을 볼 보장이 없다.
    }
}
