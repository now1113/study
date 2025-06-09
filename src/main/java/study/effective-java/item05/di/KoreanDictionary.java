package study.effective;

import java.util.Set;

public class KoreanDictionary implements Dictionary{

    private Set<String> words = Set.of("안녕", "세상", "자바");

    @Override
    public boolean contains(String word) {
        return words.contains(word);
    }
}
