package euler.problems;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 10/23/12
 */
public class Problem88 {
    private long minSumProd = Long.MAX_VALUE;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + new Problem88().solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public long solution1() {
        int limit = 12000;
        //init
        //TreeMap<Long, HashSet<Long>> factors = new TreeMap<Long, HashSet<Long>>();
        HashSet<Long> minSumProds = new HashSet<Long>();
        for (long k = 2; k <= limit; k++) {
            //System.out.println("Processing k = " + k);
            minSumProds.add(this.getMinProductSumNumber(k));
        }
        long totalSum = 0;
        for (long minSumProd : minSumProds) {
            totalSum = totalSum + minSumProd;
        }
        return totalSum;
    }

    public long getMinProductSumNumber(long k) {
        this.minSumProd = 2 * k;
        this.getProductSumNumbers(k, 0, 1, 0, minSumProd);
        return this.minSumProd;
    }

    protected void getProductSumNumbers(long k, int loop, long product, long sum, long limit) {
        if (loop == k) {
            //check if its a minProduct sum number
            if (product == sum && product < minSumProd) {
                minSumProd = product;
                //System.out.println(minSumProd);
            }
            return;
        }

        long remainingLoop = k - loop;
        if ((sum + remainingLoop) == product) {
            minSumProd = product;
            return;
        }
        for (long number = 2; number <= limit; number++) {
            long tempProduct = product * number;
            long tempSum = sum + number;

            if (tempProduct >= minSumProd || tempSum >= minSumProd) {
                return;
            }
            if (tempProduct < tempSum) {
                continue;
            }
            getProductSumNumbers(k, loop + 1, tempProduct, tempSum, number);
        }
    }
}
