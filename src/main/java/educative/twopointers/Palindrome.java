package educative.twopointers;

public class Palindrome {
    public static boolean isPalindrome(String s) {
        if ( s == null || s.length() == 0) {
            return false;
        }
        int len = s.length();
        for (int i = 0, j = len-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
