package study.effective_java.ch06_열거타입과_애너테이션.item38.연습;

public enum BasicFormat implements DocumentExporter{
    PDF {
        @Override
        public String export(String content) {
            return "[PDF 변환된 문서]" + content;
        }
    },
    EXCEL {
        @Override
        public String export(String content) {
            return "[PDF 변환된 문서]" + content;
        }
    }
}
