package euler.problems;

import euler.utils.Util;
import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 7/19/12
 */
public class Problem80 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long digitSum = 0;
        for (int num = 1; num <= 100; num++) {
            double sqrt = Math.sqrt(num);
            if ((double) (long) sqrt != sqrt) {
                String[] parts = Util.getContinuedFractions(num).split(";");
                String[] fractions = parts[1].split(",");
                int fracLen = fractions.length;
                BigFraction sum = BigFraction.ZERO;
                for (int i = 200; i > 0; i--) {
                    sum = sum.add(Integer.parseInt(fractions[(i - 1) % fracLen])).reciprocal();
                }
                sum = sum.add(Integer.parseInt(parts[0]));
                String[] decimalPart = sum.bigDecimalValue(99, BigDecimal.ROUND_DOWN).toString().split("\\.");

                for (int i = 0; i < decimalPart[1].length(); i++) {
                    digitSum = digitSum + decimalPart[1].charAt(i) - '0';
                }
                digitSum = digitSum + Integer.parseInt(parts[0]);
            }
            //System.out.println(decimalPart[1]);
        }
        return digitSum;
    }
}
