package study.effective_java.item38.연습;

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
