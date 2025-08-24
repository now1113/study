package study.effective_java.ch08_메서드.item53;

public class Min {

    static int min(int... args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("1개 이상 필요");
        }
        int min = args[0];
        for (int i = 1; i < args.length; i++) {
            if (args[i] < min) {
                min = args[i];
            }
        }
        return min;
    }

    static int minV2(int first, int... rest) {
        int min = first;
        for (int x : rest) {
            if (x < min) {
                min = x;
            }
        }
        return min;
    }
}
