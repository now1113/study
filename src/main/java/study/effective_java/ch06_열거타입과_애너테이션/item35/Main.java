package study.effective_java.ch06_열거타입과_애너테이션.item35;

public class Main {

    public static void main(String[] args) {
        int ordinal = Day.MONDAY.ordinal();
        System.out.println(ordinal);
        int ordinal2 = Day.TUESDAY.ordinal();
        System.out.println(ordinal2);
    }
}

