package euler.problems;

import euler.utils.Util;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/17/12
 */
public class Problem45 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        TreeSet<Long> hexNums = Util.getHexagonalNumbersByCount(100000);
        for (long num : hexNums) {
            if (Util.isHexagonalNumber(num)
                    && Util.isPentagonalNumber(num)
                    && Util.isTriangleNumber(num) && num > 40755) {
                return num;
            }
        }
        return 0;
    }
}
