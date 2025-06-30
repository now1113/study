package study.java.oop.encapsulation;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void changeName(String newName) {
        if (newName == null || newName.isBlank()) {
            throw new IllegalArgumentException();
        }
        this.name = newName;
    }


}
