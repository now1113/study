package 객체지향의_사실과_오해.ch07;

public class Barista {

    public Coffee makeCoffee(MenuItem menuItem) {
        Coffee coffee = new Coffee(menuItem);
        return coffee;
    }
}
