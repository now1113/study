package study.effective_java.ch08_메서드.item54;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Refrigerator {

    private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

    private List<Cheese> cheeses;

//    public List<Cheese> getCheeses() {
//        if (cheeses.isEmpty()) {
//            return null;
//        }
//        return new ArrayList<>(cheeses);
//    }

    public List<Cheese> getCheeses() {
        if (cheeses.isEmpty()) {
            return Collections.emptyList();
        }
        return List.copyOf(cheeses);
    }

    public Cheese[] getCheeseArray() {
        if (cheeses.isEmpty()) {
            return new Cheese[0];
        }
        return cheeses.toArray(new Cheese[0]);
    }

    public Cheese[] getCheeseArrayV2() {
        return cheeses.isEmpty() ? EMPTY_CHEESE_ARRAY : cheeses.toArray(new Cheese[0]);
    }
}
