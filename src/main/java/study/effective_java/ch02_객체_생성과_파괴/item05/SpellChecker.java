package study.effective_java.ch02_객체_생성과_파괴.item05;

import java.util.Objects;

public class SpellChecker {

//    private static final Dictionary dictionary = new Dictionary(); // 자원 직접 생성
//    private SpellChecker() {}   // 인스턴스화 방지
//    public static final SpellChecker INSTANCE = new SpellChecker();
//    public static boolean isValid(String word) {
//        return dictionary.contains(word);
//    }
    private final Dictionary dictionary;

    public SpellChecker(Dictionary dictionary) {
        this.dictionary = Objects.requireNonNull(dictionary);
    }

    public boolean isValid(String word) {
        return dictionary.contains(word);
    }

}
