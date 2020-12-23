package euler.problems;

import euler.utils.Util;

import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/26/12
 */
public class Problem32 {

    private static HashSet<Integer> panDigitalProducts = new HashSet<Integer>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int sum = 0;

        for (int a = 100; a < 10000; a++) {
            for (int b = 99; b > 0; b--) {
                //The Multiplier should be 5 digits
                String multiplier = String.valueOf(a) + String.valueOf(b);
                if (multiplier.length() == 5) {
                    int product = a * b;
                    String prod = multiplier + String.valueOf(product);
                    if (prod.length() == 9 && Util.getUniqueDigitCount(prod) == 9) {
                        //System.out.println(a + " * " + b + " = " + product);
                        panDigitalProducts.add(product);
                    }
                }
            }
        }
        for (int panDigitalProduct : panDigitalProducts) {
            sum = sum + panDigitalProduct;
        }
        return sum;
    }


}
