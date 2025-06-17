package study.effective_java.item38.연습;

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
