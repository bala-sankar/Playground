package euler.problems;

import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/20/12
 */
public class Problem30 {
    public static void main(String[] args) {
        System.out.println("Result is : " + solution1());
    }

    public static long solution1() {
        HashMap<Long, Long> digitPow = new HashMap<Long, Long>();
        long result = 0;
        for (long i = 0; i < 10; i++) {
            digitPow.put(i, (long) Math.pow(i, 5));
        }
        int i = 1;
        long limit = 0;
        while (String.valueOf(limit).length() >= i) {
            limit = digitPow.get(Long.valueOf(9)) * i;
            i++;
        }
        for (long j = 10; j <= limit; j++) {
            long temp = j;
            long sum = 0;
            while (temp > 0) {
                sum = sum + digitPow.get(Long.valueOf(temp % 10));
                temp = temp / 10;
            }
            if (sum == j) {
                result = result + sum;
                //System.out.println(j);
            }
        }
        return result;
    }
}
