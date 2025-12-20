package study.effective_java.연습.item77;

import java.io.File;

public class IgnoreWithReasonExample {

    public void bestEffortDelete(File tempFile) {
        try  {
            // temp 파일 삭제는 best-effort: 실패해도 치명적이지 않고, OS가 정리할 수도 있다.
            boolean deleted = tempFile.delete();
            if (!deleted) {
                // 필요하면 로그/메트릭만 남기고 진행
            }
        } catch (SecurityException ignored) {
            // 삭제 권한이 없으면 그냥 넘겨도 무방한 상황이라고 명시적으로 결정한 케이스
        }
    }
}
