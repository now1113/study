package 객체지향의_사실과_오해.ch07;

public class Coffee {

    private String name;
    private int price;

    public Coffee(MenuItem menuItem) {
        this.name = menuItem.getName();
        this.price = menuItem.cost();
    }
}
