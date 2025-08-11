package study.effective_java.ch05_제네릭.item31;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3);
        List<Number> nums = new ArrayList<>();

        Utils.copy(ints, nums); // ok
    }
}
