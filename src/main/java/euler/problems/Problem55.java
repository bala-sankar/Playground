package euler.problems;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/9/12
 */
public class Problem55 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long count = 0;
        for (long i = 10; i < 10000; i++) {
            BigInteger num = new BigInteger(String.valueOf(i));
            boolean isLychrel = false;
            int iteration = 0;
            //System.out.println(i);
            do {
                iteration++;
                num = num.add(
                        new BigInteger(
                                new StringBuilder(num.toString()).reverse().toString()));
                if (iteration == 50) {
                    isLychrel = true;
                    break;
                }
            } while (!euler.utils.Util.isPalindrome(num.toString()));
            if (isLychrel) {
                count++;
            }
        }
        return count;
    }
}
