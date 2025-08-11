package study.effective_java.ch02_객체_생성과_파괴.item05.di;

public class MockDictionary implements Dictionary{
    @Override
    public boolean contains(String word) {
        return word.equals("test");
    }
}
