package study.effective_java.ch02_객체_생성과_파괴.item05.di;

import java.util.Set;

public class EnglishDictionary implements Dictionary{

    private Set<String> words = Set.of("hello", "word", "java");

    @Override
    public boolean contains(String word) {
        return words.contains(word);
    }
}
