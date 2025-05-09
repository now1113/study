package argo.level1;


public class 크키가작은부분문자열 {

    public static void main(String[] args) {
        int solution = solution("3141592", "271");
        System.out.println("solution = " + solution);
    }

    private static int solution(String t, String p) {
        int answer = 0;
        int window = p.length();

        long pValue = Long.parseLong(p);

        for (int i = 0; i <= t.length() - window; i++) {
            String sub = t.substring(i, i + window);
            long subValue = Long.parseLong(sub);

            if (subValue <= pValue) {
                answer++;
            }
        }

        return answer;
    }
}
