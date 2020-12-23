package euler.problems;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/6/11
 */
public class Problem10 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        TreeSet<Long> primeNums = new TreeSet<Long>();
        primeNums.add(2L);
        long i = 3;
        long sum = 2;
        while (i < 2000000) {
            boolean isPrime = true;
            long sqrt = (long) Math.sqrt((double) i);
            for (long primeNum : primeNums) {
                if (primeNum > sqrt) {
                    break;
                }
                if (i % primeNum == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                //System.out.print(" " + i);
                primeNums.add(i);
                sum = sum + i;
                /*if (primeNums.size() % 20 == 0) {
                    //System.out.println();
                }*/
            }

            i = i + 2;
        }
        return sum;
    }
}
