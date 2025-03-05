package argo.level1;

public class 콜라츠추측 {

    public static void main(String[] args) {
        int solution = solution(626331);
        System.out.println("solution = " + solution);
    }

    private static int solution(long num) {
        int cnt = 0;

        while (num != 1 && cnt < 500) {
            num = (num % 2 == 0) ? num / 2 : num * 3 +1;
            cnt++;
        }
        return cnt == 500 ? -1 : cnt;
    }
}
