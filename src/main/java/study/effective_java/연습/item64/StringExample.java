package study.effective_java.연습.item64;

public class StringExample {

    public static void main(String[] args) {
        System.out.println(isPalindrome("level"));
        System.out.println(isPalindrome(new StringBuilder("abcd")));
    }

    // String으로 고정되면 StringBuilder, StringBuffer를 못받음
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    // CharSequence로 일반화
    public static boolean isPalindrome(CharSequence s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }
}
