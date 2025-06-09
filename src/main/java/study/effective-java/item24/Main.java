package study.effective;

public class Main {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();

        outer = null;
        // outer는 null로 만들었지만 inner가 outer를 참조하고 있어 GC 되지 않음 -> 메모리 누수
    }
}
