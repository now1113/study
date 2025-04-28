package argo.level1;

public class 행렬의덧셈 {

    public static void main(String[] args) {
        int[][] arr1 = {{1, 2}, {2, 3}};
        int[][] arr2 = {{3, 4}, {5, 6}};

        int[][] solution = solution(arr1, arr2);
        for (int[] ints : solution) {
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
        }
    }

    private static int[][] solution(int[][] arr1, int[][] arr2) {
        int row = arr1.length;
        int col = arr1[0].length;

        int[][] answer = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}
