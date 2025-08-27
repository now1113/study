package study.effective_java.ch08_메서드.item55;

import java.util.List;
import java.util.Optional;

public class Refrigerator {
    private List<Cheese> cheeses;

    public Optional<Cheese> findCheese(String name) {
        return cheeses.stream()
                .filter(c -> c.getName().equalsIgnoreCase(name))
                .findFirst();
    }
}
