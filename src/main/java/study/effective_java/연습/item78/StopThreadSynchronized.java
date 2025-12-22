package study.effective_java.연습.item78;

public class StopThreadSynchronized {
    private static boolean stopRequested = false;

    private static synchronized boolean isStopRequested() {
        return stopRequested;
    }

    private static synchronized void requestStop() {
        stopRequested = true;
    }

    void main() throws InterruptedException {
        Thread background = new Thread(() -> {
            long i = 0;
            while (!isStopRequested()) {
                i++;
            }
            System.out.println("stopped: " + i);
        });

        background.start();

        Thread.sleep(1000);
        requestStop();
    }
}
