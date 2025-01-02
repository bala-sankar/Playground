package educative.heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganizeString(String string1) {
        Map<Character, Integer> charCounter = new HashMap<>();
        for (char c : string1.toCharArray()) {
            charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b)
                        -> b.getValue() - a.getValue());
        maxHeap.addAll(charCounter.entrySet());
        Map.Entry<Character, Integer> previous = null;
        StringBuilder result = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> current = maxHeap.poll();
            if (previous != null && previous.getValue() > 0) {
                maxHeap.offer(previous);
            }
            result.append(current.getKey());
            current.setValue(current.getValue() - 1);
            previous = current;
        }
        return result.length() == string1.length() ? result.toString() : "";
    }
}
