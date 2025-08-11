package study.effective_java.ch02_객체_생성과_파괴.item05.di;

import java.util.Set;

public class KoreanDictionary implements Dictionary{

    private Set<String> words = Set.of("안녕", "세상", "자바");

    @Override
    public boolean contains(String word) {
        return words.contains(word);
    }
}
