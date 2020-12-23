package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/21/12
 */
public class Problem46 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long limit = 10000;
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit(limit);

        for (long i = 9; i < limit; i = i + 2) {
            boolean isComplyRule = false;
            if (primeNums.contains(i)) {
                continue;
            }
            for (long primeNum : primeNums) {
                if (primeNum >= i) {
                    break;
                }
                long twiceASquare = i - primeNum;
                if (twiceASquare % 2 == 0) {
                    long squareNum = twiceASquare / 2;
                    double num = Math.sqrt((double) squareNum);
                    if (num == (double) (long) num) {
                        isComplyRule = true;
                    }
                }
            }
            if (!isComplyRule) {
                return i;
            }

        }
        return 0;
    }
}
