package euler.problems;

import org.apache.commons.math3.fraction.Fraction;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/27/12
 */
public class Problem33 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        HashMap<Integer, Integer> unorthodoxFractions = new HashMap<Integer, Integer>();
        for (int a = 11; a < 50; a++) {
            int aOnesDigit = getOnesDigit(a);
            int aTensDigit = getTensDigit(a);
            for (int b = (a + 1); b < 100; b++) {
                int bOnesDigit = getOnesDigit(b);
                int bTensDigit = getTensDigit(b);
                if ((aOnesDigit * bOnesDigit) == 0) {
                    continue;
                }
                Fraction fraction = new Fraction(a, b);

                if (bOnesDigit == aOnesDigit) {
                    if (fraction.equals(new Fraction(aTensDigit, bTensDigit))) {
                        unorthodoxFractions.put(a, b);
                        //System.out.println(a +"\t" + b);
                    }
                } else if (bOnesDigit == aTensDigit) {
                    if (fraction.equals(new Fraction(aOnesDigit, bTensDigit))) {
                        unorthodoxFractions.put(a, b);
                        //System.out.println(a +"\t" + b);
                    }
                } else if (bTensDigit == aOnesDigit) {
                    if (fraction.equals(new Fraction(aTensDigit, bOnesDigit))) {
                        unorthodoxFractions.put(a, b);
                        //System.out.println(a +"\t" + b);
                    }
                } else if (bTensDigit == aTensDigit && fraction.equals(new Fraction(aOnesDigit, bOnesDigit))) {
                    unorthodoxFractions.put(a, b);
                    //System.out.println(a +"\t" + b);
                }
            }
        }
        long deNomProduct = 1;
        long numProduct = 1;
        //GCD
        for (int num : unorthodoxFractions.keySet()) {
            int deNom = unorthodoxFractions.get(Integer.valueOf(num));
            for (int i = num; i > 0; i--) {
                if (num % i == 0 && deNom % i == 0) {
                    numProduct = numProduct * num / i;
                    deNomProduct = deNomProduct * deNom / i;
                    break;
                }
            }
        }

        for (long j = numProduct; j > 0; j--) {
            if (numProduct % j == 0 && deNomProduct % j == 0) {
                return deNomProduct / j;
            }
        }
        return 0;
    }

    private static int getOnesDigit(int num) {
        return num % 10;
    }

    private static int getTensDigit(int num) {
        return (num / 10) % 10;
    }
}
