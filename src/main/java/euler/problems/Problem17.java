package euler.problems;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/12/11
 */
public class Problem17 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        HashMap<Integer, Integer> number = new HashMap<Integer, Integer>();
        //seed
        number.put(1, "one".length());
        number.put(2, "two".length());
        number.put(3, "three".length());
        number.put(4, "four".length());
        number.put(5, "five".length());
        number.put(6, "six".length());
        number.put(7, "seven".length());
        number.put(8, "eight".length());
        number.put(9, "nine".length());
        number.put(10, "ten".length());
        number.put(11, "eleven".length());
        number.put(12, "twelve".length());
        number.put(13, "thirteen".length());
        number.put(14, "fourteen".length());
        number.put(15, "fifteen".length());
        number.put(16, "sixteen".length());
        number.put(17, "seventeen".length());
        number.put(18, "eighteen".length());
        number.put(19, "nineteen".length());
        number.put(20, "twenty".length());
        number.put(30, "thirty".length());
        number.put(40, "forty".length());
        number.put(50, "fifty".length());
        number.put(60, "sixty".length());
        number.put(70, "seventy".length());
        number.put(80, "eighty".length());
        number.put(90, "ninety".length());
        number.put(100, "hundred".length());
        number.put(1000, "onethousand".length());
        int andLen = "and".length();
        long letterCount = 0;
        for (int i = 1; i < 1000; i++) {
            int ones = i % 10;
            int tens = (i % 100) / 10;
            int hundreds = i / 100;
            if (hundreds != 0) {
                letterCount = letterCount + number.get(hundreds) + number.get(100);
                if (!(ones == 0 && tens == 0)) {
                    letterCount = letterCount + andLen;
                }
            }
            if (tens != 0 && tens != 1) {
                letterCount = letterCount + number.get(tens * 10);
            }
            if (tens == 1) {
                letterCount = letterCount + number.get(10 + ones);
            } else {
                if (ones != 0) {
                    letterCount = letterCount + number.get(ones);
                }
            }

        }
        letterCount = letterCount + number.get(1000);
        return letterCount;
    }
}
