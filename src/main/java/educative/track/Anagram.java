package educative.track;

public class Anagram {
    public static boolean isAnagram(String str1, String str2) {

        // Replace this placeholder return statement with your code
        if (str1.length() != str2.length()) {
            return false;
        }
        int[] count = new int[26];
        for (char c : str1.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : str2.toCharArray()) {
            count[c - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
