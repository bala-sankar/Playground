package euler.problems;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/10/12
 */
public class Problem48 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static String solution1() {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 1; i <= 1000; i++) {
            BigInteger num = new BigInteger(String.valueOf(i));
            num = num.pow(i);
            sum = sum.add(num);
        }
        String num = sum.toString();
        return num.substring(num.length() - 10);
    }
}
