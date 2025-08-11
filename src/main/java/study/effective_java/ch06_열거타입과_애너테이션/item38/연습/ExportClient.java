package study.effective_java.ch06_열거타입과_애너테이션.item38.연습;

import java.util.Collection;
import java.util.EnumSet;

public class ExportClient {

    public static void exportAll(String content, Collection<? extends DocumentExporter> exporters) {
        for (DocumentExporter exporter : exporters) {
            System.out.println("[" + exporter + "] → " + exporter.export(content));
        }
    }

    public static void main(String[] args) {
        String sample = "이펙티브 자바 정리 문서";

        exportAll(sample, EnumSet.allOf(BasicFormat.class));
        exportAll(sample, EnumSet.allOf(ExtendedFormat.class));
    }
}
