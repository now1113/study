package 객체지향의_사실과_오해.ch07;

import java.util.List;

public class Menu {

    private List<MenuItem> items;

    public Menu(List<MenuItem> items) {
        this.items = items;
    }

    public MenuItem choose(String name) {
        for (MenuItem item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }
}
