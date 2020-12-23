package euler.problems;

import org.apache.commons.math3.fraction.BigFraction;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/12/12
 */
public class Problem57 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long count = 0;
        for (int i = 1; i <= 1000; i++) {
            int j = i;
            BigFraction result;
            BigFraction X = BigFraction.ONE_HALF;
            while (j > 1) {
                X = X.add(2).reciprocal();
                j--;
            }
            result = X.add(1);
            if (result.getNumerator().toString().length()
                    > result.getDenominator().toString().length()) {
                count++;
            }

        }
        return count;
    }


}
