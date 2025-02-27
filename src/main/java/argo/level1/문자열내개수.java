package argo.level1;

public class 문자열내개수 {

    public static void main(String[] args) {
        boolean pPoooyY = solution("Pyy");
        System.out.println("pPoooyY = " + pPoooyY);
    }

    static boolean solution(String str) {
        int pCnt = 0;
        int yCnt = 0;

        for (char ch : str.toLowerCase().toCharArray()) {
            if (ch == 'p') pCnt++;
            if (ch == 'y') yCnt++;
        }

        return pCnt == yCnt;
    }
}
