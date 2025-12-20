package study.effective_java.연습.item77;

public class InterruptHandlingExample {

    public void sleepSafely(long mills) {
        try {
            Thread.sleep(mills);
        } catch (InterruptedException e) {
            // 인터럽트 상태를 복구해 상위 로직이 취소를 감지할 수 있게 함
            Thread.currentThread().interrupt();
            // 필요하다면 여기서 정리 후 return / 예외 전파 선택
        }
    }
}
