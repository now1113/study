package study.effective_java.연습.item74;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Properties;

public class CheckedExceptionExample {

    /**
     * 지정한 경로의 설정 파일을 로드한다.
     *
     * @Param path 설정 파일 경로 (null 불가)
     * @return 설정 정보
     * @throws NullPointerException if path is null
     * @throws IOException          if an I/O error occurs while reading
     */
    public Properties loadConfig(Path path) throws IOException {
        return null;
    }
}
