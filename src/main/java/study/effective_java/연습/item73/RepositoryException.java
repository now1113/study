package study.effective_java.연습.item73;

public class RepositoryException extends RuntimeException {
    public RepositoryException(String message, Throwable cause) {
        super(message, cause); // 예외 연쇠
    }
}
