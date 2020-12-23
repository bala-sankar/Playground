package euler.problems;

import org.apache.commons.math3.fraction.Fraction;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 4/4/12
 */
public class Problem64 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long count = 0;
        for (double i = 0; i <= 10000; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt == (double) (long) sqrt) {
                continue;
            }

            int a = (int) sqrt;
            int limitNum = 0;
            int limitDenom = 0;
            int x = 0;
            int y = 1;
            int v = 1;
            Fraction z;
            int period = 0;
            while (true) {
                //(c-a) = v((sqrt + x) - ay)/y. Make v/y as a Fraction z. (vx-ay) as t
                z = new Fraction(v, y);
                int t = (z.getNumerator() * x - a * z.getDenominator());

                a = (int) ((z.getDenominator()) / (z.getNumerator() * sqrt + t));
                x = -t;
                y = ((int) (i) - (t * t)) * z.getNumerator();
                v = z.getDenominator();
                if (period == 0) {  //Set the limits
                    limitNum = v * x;
                    limitDenom = y;
                } else if ((v * x) == limitNum && y == limitDenom) {
                    // if you find the same numerator and the denominator,
                    // then it means the pattern is repeating. Hence, break the loop.
                    break;
                }
                period++;
            }
            if (period % 2 != 0) {
                count++;
            }
        }
        return count;
    }
}
