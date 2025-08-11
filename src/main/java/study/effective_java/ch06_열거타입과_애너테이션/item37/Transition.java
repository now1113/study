package study.effective_java.ch06_열거타입과_애너테이션.item37;

public enum Transition {
    MELT, FREEZE, BOIL, CONDENSE, SUBLIME, DEPOSIT;

    private static final Transition[][] TRANSITIONS = {
            { null, MELT, SUBLIME },
            { FREEZE, null, BOIL },
            { DEPOSIT, CONDENSE, null }
    };

    public static Transition from(Phase from, Phase to) {
        return TRANSITIONS[from.ordinal()][to.ordinal()];
    }
}
