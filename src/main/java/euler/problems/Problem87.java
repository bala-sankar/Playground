package euler.problems;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 10/3/12
 */
public class Problem87 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long max = 50000000;
        TreeSet<Long> primeNums = euler.utils.Util.getPrimeNumsByLimit((long) Math.sqrt(max - 24) + 1);
        long valuePow4, valuePow3, valuePow2;
        HashSet<Long> count = new HashSet<Long>();
        //long count = 0;
        for (long pow4Num : primeNums) {
            valuePow4 = pow4Num * pow4Num * pow4Num * pow4Num;
            if (valuePow4 > max) {
                break;
            }
            for (long pow3Num : primeNums) {
                valuePow3 = valuePow4 + (pow3Num * pow3Num * pow3Num);
                if (valuePow3 > max) {
                    break;
                }
                for (long pow2Num : primeNums) {
                    valuePow2 = valuePow3 + (pow2Num * pow2Num);
                    if (valuePow2 > max) {
                        break;
                    }
                    //System.out.println(pow2Num+"\t"+pow3Num+"\t"+pow4Num+"\t"+valuePow2);
                    count.add(valuePow2);
                }
            }

        }
        return count.size();
    }
}
