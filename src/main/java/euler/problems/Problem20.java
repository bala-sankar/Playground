package euler.problems;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/15/11
 */
public class Problem20 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        BigInteger factorial = BigInteger.ONE;
        for (int i = 100; i > 0; i--) {
            factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
        }
        String num = factorial.toString();
        long sum = 0;
        for (int i = 0; i < num.length(); i++) {
            sum = sum + Long.parseLong(num.substring(i, i + 1));
        }
        return sum;
    }
}
