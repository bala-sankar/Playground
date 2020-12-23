package euler.problems;

import euler.utils.Util;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/31/12
 */
public class Problem38 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long max = 0;
        for (int i = 2; i < 10000; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            int j = 2;
            while (true) {
                if (sb.length() < 9) {
                    sb.append((i * j));
                    j++;
                } else if (sb.length() == 9) {
                    String num = sb.toString();
                    if (Util.getUniqueDigitCount(num) == 9 && max < Long.parseLong(num)) {
                        //System.out.println(i+"\t"+num);
                        max = Long.parseLong(num);
                    }
                    break;
                } else {
                    break;
                }
            }
        }
        return max;
    }
}
