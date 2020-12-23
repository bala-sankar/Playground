package euler.problems;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/12/11
 */
public class Problem16 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        String number = BigInteger.ONE.shiftLeft(1000).toString();
        long sum = 0;
        for (int i = 0; i < number.length(); i++) {
            sum = sum + Integer.parseInt(number.substring(i, i + 1));
        }
        return sum;
    }
}
