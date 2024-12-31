package educative.track;

import java.util.HashMap;

public class PalindromePermutation {
    public static boolean permutePalindrome(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int oddCount = 0;
        for (int value : map.values()) {
            if (value % 2 != 0) {
                oddCount++;
            }
        }
        return oddCount <= 1;
    }
}
