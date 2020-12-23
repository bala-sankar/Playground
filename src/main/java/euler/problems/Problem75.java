package euler.problems;

import euler.utils.Util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 6/19/12
 */
public class Problem75 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    // Refer Problem 9 Overview document - Using a parametrisation of Pythagorean triplets
    public static long solution1() {
        //int limit = 120;
        int limit = 1500000;
        int s = 12;
        HashMap<Integer, Boolean> perimeters = new HashMap<Integer, Boolean>();
        while (s <= limit) {
            pythagoreanTriplets(s, perimeters);
            s = s + 2;
        }
        long count = 0;
        for (Map.Entry<Integer, Boolean> entry : perimeters.entrySet()) {
            if (entry.getValue().equals(Boolean.TRUE)) {
                count++;
            }
        }

        return count;
    }

    private static boolean pythagoreanTriplets(int s, HashMap<Integer, Boolean> perimeters) {
        int s2 = s / 2;
        int k;
        //int d, n, a, b, c;
        int mLimit = (int) (Math.ceil(Math.sqrt(s2)) - 1);
        for (int m = 2; m <= mLimit; m++) {
            if (s2 % m == 0) {
                int sm = s2 / m;
                while (sm % 2 == 0) {
                    sm = sm / 2;
                }

                if (m % 2 != 0) {
                    k = m + 2;
                } else {
                    k = m + 1;
                }
                while (k < (2 * m) && k <= sm) {
                    if (sm % k == 0 && Util.gcd(k, m) == 1) {
                        /*d = s2 / (k * m);
                        n = k - m;
                        a = d * (m * m - n * n);
                        b = 2 * d * m * n;
                        c = d * (m * m + n * n);*/
                        //System.out.println(a +"\t" + b +"\t" + c +"\t"+ s);
                        if (perimeters.containsKey(Integer.valueOf(s))) {
                            perimeters.put(s, false);
                        } else {
                            perimeters.put(s, true);
                        }
                    }
                    k = k + 2;
                }
            }
        }
        return false;
    }
}
