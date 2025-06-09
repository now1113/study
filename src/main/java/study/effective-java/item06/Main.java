package study.effective;



public class Main {

    public static void main(String[] args) {
        Boolean str1 = Boolean.valueOf("A");
        Boolean str2 = Boolean.valueOf("A");

//        new Boolean("str");

//        sum();
        sumV2();

        System.out.println(str1 == str2);
    }

    private static long sumV2() {
        long sum = 0L; // 원시 타입 사용
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += i;
        }
        return sum;
    }

    private static long sum() {
        Long sum = 0L;  // 오토방식으로 불필요한 객체 생성
        for (long i = 0; i < Integer.MAX_VALUE; i++) {
            sum += 1; // 오토박싱 발생
        }
        return sum;
    }
}
