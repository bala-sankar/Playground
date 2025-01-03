package educative.dynamic;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static List<String> wordBreak(String s, List<String> WordDict) {
        List<String> result = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return result;
        }
        wordBreakRecursive(s, WordDict, "", result);
        return result;
    }

    private static void wordBreakRecursive(String s, List<String> WordDict, String current, List<String> result) {
        if (s.isEmpty()) {
            result.add(current);
            return;
        }
        for (String word : WordDict) {
            if (s.startsWith(word)) {
                String next = current.isEmpty() ? word : current + " " + word;
                wordBreakRecursive(s.substring(word.length()), WordDict, next, result);
            }
        }
    }
}
