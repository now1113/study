package study.effective_java.ch10_예외.item69;

public class Exmaple {

    static class Setp {
        private final int no;

        Setp(int no) {
            this.no = no;
        }

        void climb() {
            System.out.println("climb");
        }
    }

    public static void main(String[] args) {

        Setp[] range = new Setp[10];

        try {
            int i = 0;
            while (true) {
                range[i++].climb();
            }
        } catch (ArrayIndexOutOfBoundsException e) {

        }
    }
}
