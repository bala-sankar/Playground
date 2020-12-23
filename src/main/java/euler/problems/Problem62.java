package euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/27/12
 */
public class Problem62 {
    private static HashMap<String, Integer> countMap = new HashMap<String, Integer>();
    private static HashMap<String, Long> numMap = new HashMap<String, Long>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        for (long num = 2; ; num++) {
            //System.out.println("Processing ... "+ num);
            long cube = num * num * num;
            ArrayList<String> digits = new ArrayList<String>();

            while (cube != 0) {
                long digit = cube % 10;
                digits.add(String.valueOf(digit));
                cube = cube / 10;
            }
            Collections.sort(digits);
            StringBuilder sb = new StringBuilder();
            for (String digit : digits) {
                sb.append(digit);
            }
            String map = sb.toString();
            if (!numMap.containsKey(map)) {
                numMap.put(map, num);
                countMap.put(map, 1);
                //System.out.println(map +"-"+ num+"-"+num*num*num);
            } else {
                int count = countMap.get(map);
                count++;
                countMap.put(map, count);
                //System.out.println(map +"-"+ num+"-"+num*num*num);
                if (count == 5) {
                    long n = numMap.get(map);
                    return n * n * n;
                }
            }
        }
    }
}
