package euler.problems;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/4/11
 */
public class Problem3 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution2());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long num = 600851475143L;
        //long num = 8;
        long limit = num / 2;
        TreeSet<Long> primeNums = new TreeSet<Long>();
        TreeSet<Long> primeFactors = new TreeSet<Long>();
        processPrimeNumber(num, primeNums, primeFactors, 2);
        while (num % 2 == 0) {
            num = num / 2;
            if (isResult(num, 2)) {
                return 2;
            }
        }

        for (long i = 3; i <= limit; i = i + 2) {
            boolean isPrime = true;
            for (long primeNum : primeNums) {
                if (i % primeNum == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                processPrimeNumber(num, primeNums, primeFactors, i);
                while (num % i == 0) {
                    num = num / i;
                    if (isResult(num, i)) {
                        return i;
                    }
                }
                /*if (primeNums.size() % 20 == 0) {
                    System.out.println();
                }*/
            }
        }
        return 1;
    }

    public static long solution2() {
        long num = 600851475143L;
        //long num = 8;
        long lastFactor = 0;
        long maxFactor = Math.round(Math.sqrt((double) num));

        long factor;

        if (num % 2 == 0) {
            lastFactor = 2;
            return lastFactor;
        }
        factor = 3;
        while (num > 1 && factor < maxFactor) {
            if (num % factor == 0) {
                lastFactor = factor;
                num = num / factor;
                while (num % factor == 0) {
                    num = num / factor;
                }
                maxFactor = Math.round(Math.sqrt((double) num));
            }
            factor = factor + 2;
        }
        if (num == 1) {
            return lastFactor;
        }
        return num;
    }

    private static void processPrimeNumber(long num, TreeSet<Long> primeNums, TreeSet<Long> primeFactors, long i) {
        //System.out.print(" " + i);
        primeNums.add(i);
        if (num % i == 0) {
            primeFactors.add(i);
        }
    }

    private static boolean isResult(long num, long i) {
        return num < i;
    }
}
