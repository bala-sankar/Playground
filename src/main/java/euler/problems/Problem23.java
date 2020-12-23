package euler.problems;

import euler.utils.Util;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/16/11
 */
public class Problem23 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //find all the abundant numbers till 100
        TreeSet<Integer> abundantNumbers = new TreeSet<Integer>();
        for (int i = 1; i <= 28123; i++) {
            long sum;
            HashSet<Long> factors = Util.getFactors(i);
            factors.remove(Long.valueOf(i));
            sum = Util.sum(factors);
            if (sum > i) {
                abundantNumbers.add(i);
            }
        }
        //Find the numbers that can be represented by abundant numbers
        HashSet<Integer> sumOfTwoAbundant = new HashSet<Integer>();
        for (int i : abundantNumbers) {
            for (int j : abundantNumbers) {
                sumOfTwoAbundant.add((i + j));
            }
        }
        long sum = 0;
        for (int i = 1; i <= 28123; i++) {
            if (!sumOfTwoAbundant.contains(Integer.valueOf(i))) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
