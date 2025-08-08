package educative.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> group_anagrams(String[] strs) {
        // your code goes here
        if (strs == null || strs.length == 0) {
            return List.of();
        }
        Map<String, List<String>> anagramMap = new java.util.HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            anagramMap.computeIfAbsent(sortedStr, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagramMap.values());
    }
}

