package educative.hashmaps;

import java.util.HashMap;

public class Isomorphic {
    public static boolean isIsomorphic(String string1, String string2) {
        if (string1 == null || string2 == null || string1.length() != string2.length()) {
            return false;
        }

        HashMap<Character, Character> map = new HashMap<>();

        for (int i = 0; i < string1.length(); i++) {
            char c1 = string1.charAt(i);
            char c2 = string2.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (map.containsValue(c2)) {
                    return false;
                }
                map.put(c1, c2);
            }
        }
        // Replace this placeholder return statement with your code
        return true;
    }
}
