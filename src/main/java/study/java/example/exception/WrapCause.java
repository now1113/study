package study.java.example.exception;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class WrapCause {
    private static final String orderNo = "ORD-123";
    private static final Path path = Path.of("NO_SUCH_FILE.txt");

    static void readAndPrint() {
        try {
            String content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            throw new UncheckedIOException("fail to read file for orderNo="+ orderNo, e);
        }
    }

    public static void main(String[] args) {
        readAndPrint();
    }
}
