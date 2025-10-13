package study.java.example.exception;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class CheckedVsRuntimeAPI {
    public static String readFirstLineChecked(Path path) throws IOException {
        return Files.lines(path).findFirst().orElse("");
    }

    public static String readFirstLine(Path path) {
        try {
            return readFirstLineChecked(path);
        } catch (IOException e) {
            throw new UncheckedIOException("readFirstLine failed: " + path, e);
        }
    }

    public static void main(String[] args) {
        System.out.println(readFirstLine(Path.of("NO_SUCH_FILE.txt")));
    }
}
