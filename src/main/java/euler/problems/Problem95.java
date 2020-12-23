package euler.problems;

import euler.utils.Util;

import java.util.HashSet;

/**
 * Created by bsankar on 5/15/15.
 */
public class Problem95 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long amicableChainLength = 0;
        long smallestMember;
        long ONE_MILLION = 1000000;
        for (long i = 2; i < ONE_MILLION; i++) {
            HashSet<Long> divisors = Util.getFactors(i);
            long sum;
            do {
                sum = 0;
                for (long divisor : divisors) {
                    sum = sum + divisor;
                }
//                if ()

            } while (sum == i );

        }

        return 0;

    }
}
