package educative.merge;

import java.util.HashMap;
import java.util.Map;

/*
Problem Statement:
Given a list of tasks represented by characters and a non-negative integer n representing the cooldown period between
two same tasks, return the least number of units of time that the CPU will take to finish all the given tasks.

Examples:
Input: tasks = ['A','A','A','B','B','B'], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B

Input: tasks = ['A','A','A','B','B','B'], n = 0
Output: 6
Explanation: A -> A -> A -> B -> B -> B
*/
public class TaskScheduler {
    public static int leastTime(char[] tasks, int n) {
        // If there are no tasks, return 0
        if (tasks == null || tasks.length == 0) return 0;
        // Count the frequency of each task
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char task : tasks) {
            frequencyMap.put(task, frequencyMap.getOrDefault(task, 0) + 1);
        }
        // Find the maximum frequency and how many tasks have this frequency
        int maxFreq = 0;
        int maxCount = 0;
        for (int freq : frequencyMap.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            } else if (freq == maxFreq) {
                maxCount++;
            }
        }
        // --- Visual Explanation Example ---
        // For tasks = ['A','A','A','B','B','B','C'], n = 2
        // The most frequent tasks are A and B (3 times each)
        // Part Count: Arrange as: A _ _ A _ _ A (There are 2 parts of empty spaces)
        // Part Length: Fill B in the gaps: A B _ A B _ A B (There is one empty slot for every part)
        // Fill C and idle slots if needed:
        // A B C A B idle A B
        // Total time = 8
        //
        // Calculation steps:
        // maxFreq = 3 (A or B)
        // maxCount = 2 (A and B)
        // partCount = 2 (maxFreq - 1)
        // partLength = 1 (n - (maxCount - 1))
        // emptySlots = 2 (partCount * partLength)
        // availableTasks = 1 (7 - 3*2)
        // idles = max(0, 2 - 1) = 1
        // result = 7 + 1 = 8
        //
        // The formula ensures the minimum time is calculated by filling idle slots only when necessary.

        // Calculate the number of parts (gaps between the most frequent tasks)
        int partCount = maxFreq - 1;
        // Calculate the length of each part (cooldown slots minus slots taken by other max frequency tasks)
        int partLength = n - (maxCount - 1);
        // Total empty slots to fill with other tasks or idles
        int emptySlots = partCount * partLength;
        // Tasks left after placing the most frequent ones
        int availableTasks = tasks.length - maxFreq * maxCount;
        // Idle slots needed if available tasks can't fill all empty slots
        int idles = Math.max(0, emptySlots - availableTasks);
        // Total time is tasks plus idles
        return tasks.length + idles;
    }

    public static void main(String[] args) {
        // Example usage: should print the minimum time to finish all tasks with cooldown
        // System.out.println(leastTime(new char[] { 'A', 'A', 'B', 'B' }, 2));
//        System.out.println(leastTime(new char[] { 'A', 'K', 'X', 'M', 'W', 'D', 'X', 'B','D','C','O','Z','D','E','Q' }, 3));
         System.out.println(leastTime(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));
    }
}
