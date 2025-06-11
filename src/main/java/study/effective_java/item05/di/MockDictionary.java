package study.effective_java.item05.di;

public class MockDictionary implements Dictionary{
    @Override
    public boolean contains(String word) {
        return word.equals("test");
    }
}
