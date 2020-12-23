package euler.problems;

import euler.utils.Util;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/24/12
 */
public class Problem51 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long startingFamilyValue = 0;
        ArrayList<String> nums = new ArrayList<String>();
        nums.add("0");
        nums.add("1");
        nums.add("2");
        nums.add("3");
        nums.add("4");
        nums.add("5");
        nums.add("6");
        nums.add("7");
        nums.add("8");
        nums.add("9");
        nums.add("~");
        int digits = 2;
        int count = 0;
        while (count < 8 && digits <= 8) {
            ArrayList<String> patterns = Util.getPermutationsWithRepetition(nums, digits);
            for (String pattern : patterns) {
                if (!(pattern.contains("~"))) {
                    continue;
                }
                count = 0;
                for (char i = '0'; i <= '9'; i++) {
                    long number = Long.parseLong(pattern.replace('~', i));
                    if (Util.isPrimeNumber(number)) {
                        count++;
                        if (count == 1) {
                            startingFamilyValue = number;
                        }
                        if (count - i > 1) {
                            break;
                        }
                    }
                }
                if (count >= 8) {
                    //System.out.println(pattern + "\t" + count);
                    break;
                }
            }
            digits++;
        }
        return startingFamilyValue;
    }

}
