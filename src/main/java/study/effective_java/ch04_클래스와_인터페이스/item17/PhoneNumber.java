package study.effective_java.ch04_클래스와_인터페이스.item17;

public final class PhoneNumber {

    private final int areaCode;
    private final int prefix;
    private final int lineNumber;

    public PhoneNumber(int areaCode, int prefix, int lineNumber) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNumber = lineNumber;
    }

    public int areaCode() {
        return areaCode;
    }

    public int prefix() {
        return prefix;
    }

    public int lineNumber() {
        return lineNumber;
    }

    @Override
    public String toString() {
        return areaCode + "_" + prefix + "_" + lineNumber;
    }
}
