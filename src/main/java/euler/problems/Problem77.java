package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 7/3/12
 */
public class Problem77 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int limit = 10;
        while (true) {
            TreeSet<Long> primeNums = Util.getPrimeNumsByLimit(limit);
            ArrayList<Integer> numbers = new ArrayList<Integer>();
            for (long primeNum : primeNums) {
                numbers.add((int) primeNum);
            }

            int[] ways = new int[limit + 1];
            ways[0] = 1;
            for (int number : numbers) {
                for (int t = number; t <= limit; t++) {
                    ways[t] = ways[t] + ways[t - number];
                }
            }
            if (ways[limit] > 5000) {
                return limit;
            }
            limit++;
        }
    }
}
