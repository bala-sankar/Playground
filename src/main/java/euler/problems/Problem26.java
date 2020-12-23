package euler.problems;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/28/11
 */
public class Problem26 {

    public static void main(String[] args) {
        System.out.println("Result is : " + solution1());
    }

    public static int solution1() {
        String maxLenRecurringCycle = "";
        int d = 0;
        for (int i = 2; i < 1000; i++) {
            BigDecimal fraction = BigDecimal.ONE.divide(new BigDecimal(i), 3000, BigDecimal.ROUND_DOWN);
            String num = fraction.stripTrailingZeros().toString().substring(2);
            String recurringCycle = RecurringCycle(num);
            //System.out.println(i + "\t" + num + "\t" + recurringCycle);
            if (maxLenRecurringCycle.length() < recurringCycle.length()) {
                maxLenRecurringCycle = recurringCycle;
                d = i;
            }
        }

        //System.out.println("Max recurring cycle - "+ d + "\t" + dnum + "\t" + maxLenRecurringCycle);
        return d;
    }

    private static String RecurringCycle(String str) {
        for (int pos = 0; pos <= (str.length() / 2); pos++) {
            for (int length = 1; length <= (str.length() / 2); length++) {
                String appendStart = "";
                if (pos > 0) {
                    appendStart = str.substring(0, pos);
                }
                String appendEnd = "";
                String subPattern = str.substring(pos, pos + length);
                if (subPattern.length() > 1) {
                    appendEnd = "(.){0," + (subPattern.length() - 1) + "}";
                }
                String pattern = appendStart + "(" + subPattern + "){2,}" + appendEnd;
                if (str.matches(pattern)) {
                    return subPattern;
                }
            }
        }
        // if(str.length() < )
        return "";
    }
}
