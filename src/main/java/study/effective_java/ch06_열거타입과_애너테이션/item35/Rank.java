package study.effective_java.ch06_열거타입과_애너테이션.item35;

public enum Rank {
    FIRST(1),
    SECOND(2),
    THIRD(3);

    private final int value;

    Rank(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

