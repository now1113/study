package study.effective;

public class MockDictionary implements Dictionary{
    @Override
    public boolean contains(String word) {
        return word.equals("test");
    }
}
