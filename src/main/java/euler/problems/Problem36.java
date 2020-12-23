package euler.problems;

import euler.utils.Util;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/30/12
 */
public class Problem36 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long sum = 0;
        for (long num = 1; num < 1000000; num++) {
            if (Util.isPalindrome(num) && Util.isPalindrome(Long.toBinaryString(num))) {
                //System.out.println(num +"\t"+ Long.toBinaryString(num));
                sum = sum + num;
            }
        }
        return sum;
    }
}
