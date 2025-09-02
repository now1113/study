package study.effective_java.ch09_일반적인_프로그래밍_원칙.item58;

import java.util.*;

public class Loop {

    private static int[] arr = {1, 2, 3, 4};
    private static List<Element> list = new ArrayList<>();
    private static Map<Element, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Loop loop = new Loop();
        loop.forRemove();
        loop.useFor();
    }

    public void useFor() {
        List<String> lists = new ArrayList<>();
        lists.add(" 안녕");

        for (String s : lists) {
            s = s.trim();
        }
        System.out.println(lists.get(0));

        for (int i = 0; i < lists.size(); i++) {
            lists.set(i, lists.get(i).trim());
        }
        System.out.println(lists.get(0));
    }

    public void parallelFor() {
        List<String> a = new ArrayList<>();
        List<String> b = new ArrayList<>();

        for (int i = 0; i < a.size(); i++) {
            zip(a.get(i), b.get(i));
        }
    }

    public void zip(String a, String b) {

    }


    public void forRemove() {
        for (Element element : list) {
            if (element.e == 1) {
                // ConcurrentModificationException 위험
                list.remove(element);
            }
        }

        for(Iterator<Element> it = list.iterator(); it.hasNext(); ) {
            if (it.next().e == 1) {
                it.remove();
            }
        }

        list.removeIf(e -> e.e == 1);
    }

    public void keySet() {
        for (Element element : map.keySet()) {
            Integer value = map.get(element);
            process(value);
        }
    }

    public void entrySet() {
        for (Map.Entry<Element, Integer> elementIntegerEntry : map.entrySet()) {
            process(elementIntegerEntry.getValue());
        }
    }

    static class Element {
        private int e;

        public Element(int e) {
            this.e = e;
        }
    }

    public void process(int i) {
        System.out.println(i);
    }

    public void arrFor() {
        for (int i = 0; i < arr.length; i++) {
            process(arr[i]);
        }
    }

    public void iterator() {
        for (Iterator<Element> it = list.iterator(); it.hasNext(); ) {
            Element e = it.next();
            process(e.e);
        }
    }

    public void forEach() {
        for (Element element : list) {
            process(element.e);
        }

        for (int i : arr) {
            process(i);
        }
    }
}
