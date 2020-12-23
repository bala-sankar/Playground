package euler.problems;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 7/18/12
 */
public class Problem78 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int limit = 60000;
        long minT = Long.MAX_VALUE;

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for (int i = 1; i <= limit; i++) {
            numbers.add(i);
        }

        long[] ways = new long[limit + 1];
        ways[0] = 1;
        for (int number : numbers) {
            for (int t = number; t <= limit; t++) {
                ways[t] = (ways[t] + ways[t - number]) % 1000000;
                if (t == number && ways[t] == 0 && t < minT) {
                    minT = t;
                }
            }
        }
        return minT;
    }
}
