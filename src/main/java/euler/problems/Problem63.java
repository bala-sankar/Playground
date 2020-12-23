package euler.problems;

import java.math.BigInteger;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 4/3/12
 */
public class Problem63 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int count = 0;
        for (int i = 1; i < 10; i++) {
            int j = 1;
            BigInteger num = new BigInteger(String.valueOf(i));
            while (num.pow(j).toString().length() == j) {
                count++;
                j++;
            }
        }
        return count;
    }
}
