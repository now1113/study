package study.effective;

import java.util.Set;

public class EnglishDictionary implements Dictionary{

    private Set<String> words = Set.of("hello", "word", "java");

    @Override
    public boolean contains(String word) {
        return words.contains(word);
    }
}
