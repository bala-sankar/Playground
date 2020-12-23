package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 6/7/12
 */
public class Problem74 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        HashMap<Integer, Integer> factorials = new HashMap<Integer, Integer>();
        int product = 1;
        int chains = 0;
        factorials.put(0, product);
        for (int i = 1; i < 10; i++) {
            product = product * i;
            factorials.put(i, product);
            //System.out.println(i +"\t"+ product);
        }

        for (int i = 1; i < 1000000; i++) {
            long currSeq = i;
            HashSet<Long> chainList = new HashSet<Long>();
            while (!chainList.contains(currSeq)) {
                if (chainList.size() > 61) {
                    break;
                }
                ArrayList<Integer> digits = Util.getDigits(currSeq);
                long sumOfFactorial = 0;
                for (Integer digit : digits) {
                    sumOfFactorial = sumOfFactorial + factorials.get(digit);
                }
                chainList.add(currSeq);
                currSeq = sumOfFactorial;
            }
            if (chainList.size() == 60) {
                chains++;
            }
        }
        return chains;
    }
}
