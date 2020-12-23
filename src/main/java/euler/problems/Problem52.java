package euler.problems;

import euler.utils.Util;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/28/12
 */
public class Problem52 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        for (long num = 11; num < 1000000; num++) {
            String sortedDigitString = Util.getSortedDigitsAsString(num);
            if (sortedDigitString.equals(Util.getSortedDigitsAsString(2 * num)) &&
                    sortedDigitString.equals(Util.getSortedDigitsAsString(3 * num)) &&
                    sortedDigitString.equals(Util.getSortedDigitsAsString(4 * num)) &&
                    sortedDigitString.equals(Util.getSortedDigitsAsString(5 * num)) &&
                    sortedDigitString.equals(Util.getSortedDigitsAsString(6 * num))) {
                return num;
            }

        }
        return 0;
    }


}
