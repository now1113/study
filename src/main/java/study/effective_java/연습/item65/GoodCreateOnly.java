package study.effective_java.연습.item65;

public class GoodCreateOnly {
    public static void main(String[] args) {
        String fqcn = GUpperPlugin.class.getName();
        // 리플렉션은 여기서 한번
        GPlugin plugin = Plugins.create(fqcn);
        // 이후에는 인터페이스로 안전하게 처리
        System.out.println(plugin.run("hello"));
    }
}
