package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/27/12
 */
public class Problem34 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        HashMap<Integer, Integer> factorials = new HashMap<Integer, Integer>();
        HashSet<Integer> allowedDigits = new HashSet<Integer>();
        long total = 0;
        int product = 1;// sum = 0;
        factorials.put(0, product);
        for (int i = 1; i < 10; i++) {
            product = product * i;
            //sum = sum + product;
            factorials.put(i, product);
            //System.out.println(i +"\t"+ product);
        }

        long start = 11, limit;
        allowedDigits.add(0);
        allowedDigits.add(1);
        allowedDigits.add(2);
        allowedDigits.add(3);
        for (int i = 4; i <= 10; i++) {
            if (i < 10) {
                limit = factorials.get(i);
            } else {
                //99999999! = 36288000, hence the the max limit should be 100000000
                limit = 100000000;
            }
            for (long j = start; j < limit; j++) {
                ArrayList<Integer> digits = Util.getDigits(j);
                if (i < 10 && !(allowedDigits.containsAll(digits))) {
                    continue;
                }

                int sum = 0;
                for (int digit : digits) {
                    sum = sum + factorials.get(Integer.valueOf(digit));
                }
                if (sum == j) {
                    total = total + sum;
                    //System.out.println(j);
                }
            }
            if (i < 10) {
                start = limit;
                allowedDigits.add(i);
            }
        }


        return total;
    }
}
