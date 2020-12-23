package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/20/12
 */
public class Problem27 {
    public static void main(String[] args) {
        System.out.println("Result is : " + solution1());
    }

    public static long solution1() {
        //Load list of prime numbers under 1000
        TreeSet<Long> bList = Util.getPrimeNumsByLimit(1000L);
        //Performance - Assumption : prime number generated falls under first 10,000 prime numbers
        TreeSet<Long> primeNums = Util.getPrimeNumsByCount(10000L);
        long coeff_1 = 0, coeff_2 = 0, maxcount = 0;
        //Form equations
        for (long b : bList) {
            //System.out.println("Computing for b = " + b);
            for (long a = -999; a < 1000; a++) {
                //System.out.print(" "+a);
                boolean isResultPrime = true;
                int i = 0;
                while (isResultPrime) {

                    long result = (i * i) + (a * i) + b;
                    if (primeNums.contains(result)) {
                        i++;
                    } else {
                        if (i > maxcount) {
                            coeff_1 = a;
                            coeff_2 = b;
                            maxcount = i;
                        }
                        isResultPrime = false;
                    }
                }
            }
        }
        //System.out.println("a="+coeff_1+";b="+coeff_2+";count="+maxcount);
        return (coeff_1 * coeff_2);
    }
}
