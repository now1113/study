package argo.level1;

public class 하샤드수 {

    public static void main(String[] args) {
        boolean solution = solution(11);
        System.out.println("solution = " + solution);
    }

    private static boolean solution(int x) {
        int sum = String.valueOf(x)
                .chars()
                .map(Character::getNumericValue)
                .sum();

        return x % sum == 0;
    }
}
