package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/2/11
 */
/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */
public class Problem1 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution2());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution2() {
        int n = 999;
        int nBy3 = (n / 3);
        int nBy5 = (n / 5);
        int nBy15 = (n / 15);
        //System.out.println(nBy3 + " " + nBy5 + " " + nBy15);
        return (3 * (nBy3 * (nBy3 + 1)) + 5 * (nBy5 * (nBy5 + 1)) - 15 * (nBy15 * (nBy15 + 1))) / 2;
    }

    public static long solution1() {
        long sum = 0;
        for (int i = 1; i < 1000; i++) {
            if ((i % 3 == 0) || (i % 5 == 0)) {
                sum = sum + i;
            }
        }
        return sum;
    }
}
