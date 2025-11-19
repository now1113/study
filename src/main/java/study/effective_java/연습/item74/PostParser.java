package study.effective_java.연습.item74;

public class PostParser {

    /**
     * 문자열 text를 받아, 정수형 포트번호로 반환한다.
     *
     * @param text  포트를 나타내는 문자열 (예: "8080")
     * @return  포트 번호 (0 이상 65535 이하의 정수)
     * @throws NumberFormatException if text is {@code null} or does not contain a parsable integer
     * @throws IllegalArgumentException if the parsed port is out of range (port < 0 || port> 65535)
     */
    public int parsePort(String text) {
        int port = Integer.parseInt(text);

        if (port < 0 || port > 65535) {
            throw new IllegalArgumentException("port out of range: " + port);
        }
        return port;
    }
}
