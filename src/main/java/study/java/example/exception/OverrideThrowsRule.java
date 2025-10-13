package study.java.example.exception;

import java.io.FileNotFoundException;
import java.io.IOException;

class Base {
    void f() throws IOException {}
}

class Child extends Base {
    @Override
    void f() throws FileNotFoundException {
        throw new FileNotFoundException("not found");
    }
}

public class OverrideThrowsRule {
    public static void main(String[] args) {
        Base b = new Child();
        try {
            b.f();
        } catch (IOException e) {
            System.out.println("caught: " + e.getClass().getSimpleName());
        }
    }
}
