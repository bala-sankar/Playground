public class ValidatePalindrome{
    public static boolean isPalindrome(String s) {
        if ( s == null || s.length() == 0) {
            return false;
        }
        for (int i = 0, j = s.length()-1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}