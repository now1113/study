package study.effective_java.ch09_일반적인_프로그래밍_원칙.item59;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Example {

    private static final List<String> parts = new ArrayList<>();

    public void join() {
        // 직접 문자열 합치기
        String s = "";
        for (String part : parts) {
            s += "," + part;
        }

        // 표준 라이브러리
        String s1 = String.join(",", parts);
    }

    public void dateParsing() {
        // 날짜 파싱 직접 구현
        String y = "";
        String m = "";
        String day = "";
        String input = "";
        LocalDate date = LocalDate.of(
                Integer.parseInt(y), Integer.parseInt(m), Integer.parseInt(day)
        );

        // java.time + formatter
        DateTimeFormatter F = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse(input, F);
    }
}
