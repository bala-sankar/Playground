package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 6/7/12
 */
public class Problem72 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution2());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        final int limit = 1000;
        long count = (limit - 1);
        for (int n = 1; n < limit; n++) {
            for (int d = n + 1; d <= limit; d++) {
                if (d % n != 0 && Util.gcd(n, d) == 1) {
                    //System.out.println(n+"/"+d);
                    count++;
                }
                if (count == Long.MAX_VALUE) {
                    System.out.println("We have an issue");
                }
            }
        }
        return count;
    }

    //Farey sequence - F(n) = 1 + (phi(1)+....+phi(n))
    //Exclude 0 and 1 from the sequence. Hence, subtract 2 from the final count
    public static long solution2() {
        final int limit = 1000000;
        long count = 1;
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit((long) Math.sqrt(limit));
        for (int m = 1; m <= limit; m++) {
            count = count + (long) Util.phiFunction(m, primeNums);
        }
        return (count - 2);
    }
}
