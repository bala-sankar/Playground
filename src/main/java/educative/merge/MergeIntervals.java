package educative.merge;

import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] mergeIntervals(int[][] intervals) {
        // your code goes here
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new java.util.ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Non-overlapping interval, add the current one to the list
                merged.add(currentInterval);
                currentInterval = intervals[i];
            }
        }
        // Add the last interval
        merged.add(currentInterval);
        return merged.toArray(new int[merged.size()][]);
    }
}
