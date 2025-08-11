package study.effective_java.ch06_열거타입과_애너테이션.item40;

public class Bigram {
    private final char first;
    private final char second;

    public Bigram(char first, char second) {
        this.first = first;
        this.second = second;
    }

    // Object가 아닌 Bigram을 인자로 받아 오버로딩됨
//    public boolean equals(Bigram bigram) {
//        return bigram.first == first && bigram.second == second;
//    }
//
//    public int hashCode() {
//        return 31 * first + second;
//    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Bigram)) return false;
        Bigram bigram = (Bigram) o;
        return bigram.first == first && bigram.second == second;
    }

    @Override
    public int hashCode() {
        return 31 * first + second;
    }
}
