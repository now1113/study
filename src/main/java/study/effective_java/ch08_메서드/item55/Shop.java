package study.effective_java.ch08_메서드.item55;

public class Shop {
    private final Refrigerator refrigerator;

    public Shop(Refrigerator refrigerator) {
        this.refrigerator = refrigerator;
    }

    public Cheese findCheese(String name) {
        Cheese defaultCheese = new Cheese("defaultCheese");

        return refrigerator.findCheese(name)
                .orElse(defaultCheese);
    }
}
