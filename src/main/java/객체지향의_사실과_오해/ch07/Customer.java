package 객체지향의_사실과_오해.ch07;

public class Customer {

    public void order(String menuName, Menu menu, Barista barista) {
        MenuItem menuItem = menu.choose(menuName);
        Coffee coffee = barista.makeCoffee(menuItem);
    }
}
