package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/7/12
 */
public class Problem40 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {

        int d1 = GetNthDigitIntConcat(1);
        int d10 = GetNthDigitIntConcat(10);
        int d100 = GetNthDigitIntConcat(100);
        int d1000 = GetNthDigitIntConcat(1000);
        int d10000 = GetNthDigitIntConcat(10000);
        int d100000 = GetNthDigitIntConcat(100000);
        int d1000000 = GetNthDigitIntConcat(1000000);
        return d1 * d10 * d100 * d1000 * d10000 * d100000 * d1000000;
    }

    private static int GetNthDigitIntConcat(int n) {
        int pos = 0, digits = 1, unit = 1;
        while (true) {
            int incr = digits * unit;
            for (int i = 1; i < 10; i++) {
                pos = pos + incr;
                if (pos >= n) {
                    int curStartPos = pos - incr + 1;
                    int curStartNum = (i * unit);
                    int offsetPos = n - curStartPos;
                    int offsetNum = offsetPos / digits;
                    int digitToConsider = offsetPos % digits;
                    int num = curStartNum + offsetNum;
                    //System.out.println(n+"\t"+ digit + "\t" + num);
                    return Integer.valueOf(String.valueOf(String.valueOf(num).charAt(digitToConsider)));
                }
            }
            digits++;
            unit = unit * 10;
        }
    }
}
