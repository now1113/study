package study.effective_java.연습.item77;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class BadCatchExample {

    public void save(Path path, String content) {
        try {
            Files.writeString(path, content);
        } catch (IOException e) {
            // 절대 이렇게 하지 말자: 실패했는데 성공한 것처럼 흐름이 계속됨
        }
    }
}
