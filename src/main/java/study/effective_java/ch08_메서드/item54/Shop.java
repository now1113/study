package study.effective_java.ch08_메서드.item54;

import java.util.List;

public class Shop {

    private Refrigerator refrigerator;

    public void buyCheese() {
        List<Cheese> cheeses = refrigerator.getCheeses();
        for (Cheese cheese : cheeses) {
            // 로직 진행
        }
//        if (cheeses != null & !cheeses.isEmpty()) {
//            // 이후 로직 진행
//        }
    }
}
