package educative.merge;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
    public static int[][] insertInterval(int[][] existingIntervals, int[] newInterval) {

        if (existingIntervals == null || existingIntervals.length == 0) {
            return new int[][] { newInterval };
        }
        List<int []> result = new ArrayList<>();
        for (int[] existingInterval : existingIntervals) {
            if (existingInterval[1] < newInterval[0]) {
                result.add(existingInterval);
            } else {
                if (existingInterval[0] > newInterval[1]) {
                    result.add(newInterval);
                    newInterval = existingInterval;
                } else {
                    newInterval[0] = Math.min(existingInterval[0], newInterval[0]);
                    newInterval[1] = Math.max(existingInterval[1], newInterval[1]);
                }
            }
        }
        result.add(newInterval);
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 4 }, {5, 8}, { 9, 15 } };
        int[] newInterval = { 2, 5 };
        int[][] result = insertInterval(intervals, newInterval);
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }

}
