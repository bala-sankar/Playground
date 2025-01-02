package educative.merge;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersections {
    public static int[][] intervalsIntersection(int[][] intervalLista, int[][] intervalListb) {
        int i = 0, j = 0;
        int start, end;
        List<int[]> result = new ArrayList<>();
        int index = 0;
        while (i < intervalLista.length && j < intervalListb.length) {
            start = Math.max(intervalLista[i][0], intervalListb[j][0]);
            end = Math.min(intervalLista[i][1], intervalListb[j][1]);
            if (start <= end) {
                result.add(new int[] { start, end });
            }
            if (intervalLista[i][1] < intervalListb[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] intervalLista = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] intervalListb = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        int[][] result = intervalsIntersection(intervalLista, intervalListb);
        for (int[] interval : result) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
    }
}
