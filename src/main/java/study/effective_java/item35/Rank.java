package study.effective_java.item35;

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

