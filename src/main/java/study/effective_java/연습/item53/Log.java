package study.effective_java.연습.item53;

import study.effective_java.연습.Level;

public class Log {

    static void out(Level level, String message) {

    }

    static void logf(Level level, String message) {
        out(level, message);
    }

    static void logf(Level level, String message, Object a1) {
        out(level, message.formatted(a1));
    }

    static void logf(Level level, String message, Object a1, Object a2, Object... rest) {
        out(level, message.formatted(a1, a2, rest));
    }
}
