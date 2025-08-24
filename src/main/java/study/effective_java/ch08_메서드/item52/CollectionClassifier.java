package study.effective_java.ch08_메서드.item52;

import java.util.*;

public class CollectionClassifier {

    public static String classify(Set<?> s) {
        return "Set";
    }

    public static String classify(List<?> l) {
        return "List";
    }

    public static String classify(Collection<?> c) {
        if (c instanceof Set) {
            return "Set";
        }
        if (c instanceof List) {
            return "List";
        }
        return "Collection";
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {
                new HashSet<String>(),
                new ArrayList<String>(),
                new HashSet<String>(),
        };

        for (Collection<?> collection : collections) {
            System.out.println(classify(collection));
        }
    }
}
