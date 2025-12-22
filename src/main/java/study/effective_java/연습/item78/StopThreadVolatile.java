package study.effective_java.연습.item78;

public class StopThreadVolatile {
    // 단순 플래그일 때 괜찮다.
    private static volatile boolean stopRequested = false;

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
        stopRequested = true;
    }
}
