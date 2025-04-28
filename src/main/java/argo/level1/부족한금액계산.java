package argo.level1;

public class 부족한금액계산 {

    public static void main(String[] args) {
        long solution = solution(3, 20, 4);
        System.out.println("solution = " + solution);
    }


    private static long solution(int price, int money, int count) {
        long totalCost = (long) price * count * (count + 1) / 2;
        return money >= totalCost ? 0 : totalCost - money;
    }
}
