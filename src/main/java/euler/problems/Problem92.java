package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 11/15/12
 */
public class Problem92 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int chains = 0;

        for (long i = 1; i < 10000000; i++) {
            long currSeq = i;
            while (currSeq != 1 && currSeq != 89) {
                ArrayList<Integer> digits = Util.getDigits(currSeq);
                long sumOfSquares = 0;

                for (Integer digit : digits) {
                    sumOfSquares = sumOfSquares + (digit * digit);
                }
                currSeq = sumOfSquares;
            }
            if (currSeq == 89) {
                chains++;
            }
        }
        return chains;
    }
}
