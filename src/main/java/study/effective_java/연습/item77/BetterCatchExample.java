package study.effective_java.연습.item77;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BetterCatchExample {

    public void save(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            throw new IllegalStateException("파일 저장에 실패했습니다. path = " + path, e);
        }
    }
}
