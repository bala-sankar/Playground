package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/30/12
 */
public class Problem37 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //Initial set - assuming the first 11 truncatable prime is
        //              within first 100000 primes
        TreeSet<Long> primeNums = Util.getPrimeNumsByCount(100000);
        long count = 0, sum = 0;
        for (long num : primeNums) {
            if (isTruncatablePrime(primeNums, num)) {
                //System.out.println(num);
                sum = sum + num;
                count++;
            }
            if (count == 11) {
                break;
            }
        }
        if (count != 11) {
            sum = 0;
        }
        return sum;
    }

    public static boolean isTruncatablePrime(TreeSet<Long> primeNum, long num) {
        int j = 10;
        boolean isTrunPrime = true;
        if (num < 10) {
            return false;
        }
        while (num / j > 0) {
            if (!(primeNum.contains(num % j) && primeNum.contains(num / j))) {
                isTrunPrime = false;
                break;
            }
            j = j * 10;
        }
        return isTrunPrime;
    }
}
