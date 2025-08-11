package study.effective_java.ch06_열거타입과_애너테이션.item37;

import java.util.EnumMap;
import java.util.Map;

import static study.effective_java.ch06_열거타입과_애너테이션.item37.Phase.*;

public enum TransitionV2 {
    MELT(SOLID, LIQUID),
    FREEZE(LIQUID, SOLID),
    BOIL(LIQUID, GAS),
    CONDENSE(GAS, LIQUID),
    SUBLIME(SOLID, GAS),
    DEPOSIT(GAS, SOLID);

    private final Phase from;
    private final Phase to;

    TransitionV2(Phase from, Phase to) {
        this.from = from;
        this.to = to;
    }

    // 이중 EnumMap
    private static final Map<Phase, Map<Phase, TransitionV2>> map = new EnumMap<>(Phase.class);

    static {
        for (Phase p : Phase.values())
            map.put(p, new EnumMap<>(Phase.class));
        for (TransitionV2 trans : TransitionV2.values())
            map.get(trans.from).put(trans.to, trans);
    }

    public static TransitionV2 from(Phase from, Phase to) {
        return map.get(from).get(to);
    }
}
