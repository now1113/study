package study.effective_java.item05.di;


public class Main {

    public static void main(String[] args) {
        //
        SpellChecker spellChecker = new SpellChecker(new EnglishDictionary());
        System.out.println(spellChecker.isValid("java"));

        SpellChecker spellCheckerKorean = new SpellChecker(new KoreanDictionary());
        System.out.println(spellCheckerKorean.isValid("자바"));
    }
}
