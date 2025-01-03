package educative.merge;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// TODO: Broken solution
public class TaskScheduler {
    public static int leastTime(char[] tasks, int n) {
        PriorityQueue<Map.Entry<Character, Integer>> minHeap = new PriorityQueue<>(
                (a, b) -> a.getValue() - b.getValue());
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char task : tasks) {
            frequencyMap.put(task, frequencyMap.getOrDefault(task, 0) + 1);
        }
        minHeap.addAll(frequencyMap.entrySet());
        int leastTime = 0;
        while (!minHeap.isEmpty()) {
            int workTime = 0;
            int idleTime = 0;
            Map<Character, Integer> tempMap = new HashMap<>();
            while (!minHeap.isEmpty()) {
                Map.Entry<Character, Integer> entry = minHeap.poll();
                workTime++;
                if (entry.getValue() > 1) {
                    tempMap.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            minHeap.addAll(tempMap.entrySet());
            idleTime = n - workTime + 1;
            leastTime += workTime + (minHeap.isEmpty() ? 0 : Math.max(0, idleTime));
        }

        return leastTime;
    }

    public static void main(String[] args) {
//        System.out.println(leastTime(new char[] { 'A', 'A', 'B', 'B' }, 2));
        System.out.println(leastTime(new char[] { 'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B','D','C','O','Z','D','E','Q' }, 3));
//        System.out.println(leastTime(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
    }
}
