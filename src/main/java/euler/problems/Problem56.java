package euler.problems;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/12/12
 */
public class Problem56 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long maxSum = 0;
        int ZERO = '0';
        for (int i = 1; i < 100; i++) {
            BigInteger a = new BigInteger(String.valueOf(i));
            for (int j = 1; j < 100; j++) {
                long sum = 0;
                String num = a.pow(j).toString();
                for (int index = 0; index < num.length(); index++) {
                    sum = sum + ((int) num.charAt(index) - ZERO);
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }
        return maxSum;
    }
}
