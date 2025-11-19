package study.effective_java.연습.item73;

public class MemberServiceException extends RuntimeException {
    public MemberServiceException(String message, Throwable cause) {
        super(message, cause); // 예외 연쇠
    }
}
