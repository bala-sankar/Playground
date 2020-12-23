package euler.problems;

import org.apache.commons.math3.fraction.BigFraction;

import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 4/6/12
 */
public class Problem65 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        double number = (Math.E) * (Math.E);
        double sqrt = Math.sqrt(number);

        int a = (int) sqrt;

        TreeMap<Integer, Integer> terms = new TreeMap<Integer, Integer>();
        terms.put(1, a);
        int limit = 100;
        int m = 0, l = 1;
        for (int j = 2; j <= limit; j++) {
            if (m == 0 || m == 2) {
                terms.put(j, 1);
            } else {
                terms.put(j, 2 * l);
                l++;
            }
            m++;
            m = m % 3;
        }
        BigFraction sum = BigFraction.ZERO;
        for (int k = limit; k >= 1; k--) {
            sum = sum.add(terms.get(k));
            sum = sum.reciprocal();
        }
        sum = sum.reciprocal();
        long digitSum = 0;
        for (int digit : euler.utils.Util.getDigits(sum.getNumerator().toString())) {
            digitSum = digitSum + digit;
        }
        return digitSum;
    }
}

