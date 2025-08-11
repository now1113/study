package study.effective_java.ch06_열거타입과_애너테이션.item38.연습;

public enum ExtendedFormat implements DocumentExporter{
    HTML {
        @Override
        public String export(String content) {
            return "<html><body>" + content + "</body></html>";
        }
    },
    MARKDOWN {
        @Override
        public String export(String content) {
            return "# " + content;
        }
    }
}
