package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 5/17/12
 */
public class Problem69 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //Fraction maxNByPhi = Fraction.ZERO;
        double maxNByPhi = 0;
        long maxN = 0;
        long nLimit = 1000000;
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit((long) Math.sqrt((double) nLimit));
        //TreeSet<Long> primeNums = Util.getPrimeNumsByCount(35000);
        for (long n = 2; n <= nLimit; n++) {
            double nByPhi;
            double phi = Util.phiFunction(n, primeNums);
            nByPhi = (double) n / phi;
            if (maxNByPhi < nByPhi) {
                //System.out.println(n + "~" + phi + "~" + nByPhi);
                maxNByPhi = nByPhi;
                maxN = n;
            }
        }
        return maxN;
    }

    //Solution based on 069_overview.pdf
    /*public static long solution2(){


    }*/
}
