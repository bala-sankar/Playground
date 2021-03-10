package euler.problems;

import euler.utils.Util;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/4/11
 */
/*
A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

Find the largest palindrome made from the product of two 3-digit numbers.
 */
public class Problem4 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long max = 0;
        for (int num1 = 999; num1 >= 100; num1--) {
            for (int num2 = 999; num2 >= num1; num2--) {
                long product = num1 * num2;
                if (product <= max) {
                    break;
                }
                if (Util.isPalindrome(product)) {
                    max = product;
                }
            }
        }
        return max;
    }
}
