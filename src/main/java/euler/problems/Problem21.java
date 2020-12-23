package euler.problems;

import euler.utils.Util;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/15/11
 */
public class Problem21 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        HashMap<Integer, Long> factorSum = new HashMap<Integer, Long>();
        long pairSum = 0;
        for (int i = 1; i < 10000; i++) {
            long sum;
            HashSet<Long> factors = Util.getFactors(i);
            factors.remove(Long.valueOf(i));
            sum = Util.sum(factors);
            factorSum.put(i, sum);
        }
        for (int i = 1; i < 10000; i++) {
            long value = factorSum.get(i);
            if (value > 0 && value < 10000 && value != i && factorSum.get((int) value) == i) {
                pairSum = pairSum + i;
            }
        }
        return pairSum;
    }


}
