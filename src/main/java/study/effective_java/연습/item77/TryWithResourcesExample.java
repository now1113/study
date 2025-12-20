package study.effective_java.연습.item77;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TryWithResourcesExample {

    public String readFirstLine(Path path) throws IOException {
        // close 관련 예외 처리를 사람이 "대충 무시"하지 않게 구조적으로 안전해짐
        try (BufferedReader br = Files.newBufferedReader(path)) {
            return br.readLine();
        }
    }
}
