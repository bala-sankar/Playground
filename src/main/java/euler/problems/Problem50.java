package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/24/12
 */
public class Problem50 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit(1000000);
        long sum;
        int chain;
        TreeSet<Long> tempPrimes = new TreeSet<Long>();
        tempPrimes.addAll(primeNums);
        long maxChain = 0, maxChainPrime = 0;
        for (Long num : primeNums) {
            chain = 0;
            sum = 0;
            for (long primeNum : tempPrimes) {
                sum = sum + primeNum;
                if (sum > 1000000) {
                    break;
                }
                chain++;
                if (Util.isPrimeNumber(sum) && chain > maxChain) {
                    maxChainPrime = sum;
                    maxChain = chain;
                    //System.out.println(sum + "\t" + num +"\t"+primeNum + "\t" + chain);
                }
            }
            tempPrimes.remove(num);
        }

        return maxChainPrime;
    }
}
