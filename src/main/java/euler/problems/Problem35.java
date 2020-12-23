package euler.problems;

import euler.utils.Util;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/27/12
 */
public class Problem35 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit(1000000);
        HashSet<Long> circularPrime = new HashSet<Long>();
        for (long primeNum : primeNums) {
            boolean isCircularPrime = false;
            if (circularPrime.contains(Long.valueOf(primeNum))) {
                continue;
            }
            String primeStr = String.valueOf(primeNum);
            StringBuilder str = new StringBuilder(primeStr);
            HashSet<Long> temp = new HashSet<Long>();
            while (true) {
                char rotateChar = str.charAt(0);
                String tempNum = str.deleteCharAt(0).append(rotateChar).toString();
                if (!primeNums.contains(Long.valueOf(tempNum))) {
                    break;
                }
                temp.add(Long.parseLong(tempNum));
                if (tempNum.equals(primeStr)) {
                    isCircularPrime = true;
                    break;
                }
            }
            if (isCircularPrime) {
                circularPrime.addAll(temp);
            }
        }
        return circularPrime.size();
    }
}
