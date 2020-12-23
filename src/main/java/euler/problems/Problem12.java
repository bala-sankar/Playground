package euler.problems;

import euler.utils.Util;

import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/12/11
 */
public class Problem12 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //System.out.println("Result is : " + solution1());
        //System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        //startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution2());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long i = 1000;
        long triangleNum = (i * (i + 1)) / 2;
        while (true) {
            i++;
            triangleNum = triangleNum + i;
            HashSet<Long> factors = Util.getFactors(triangleNum);
            //System.out.println(i + "\t" + triangleNum + "\t" + factors.size());
            if (factors.size() > 500) {
                return triangleNum;
            }
        }
    }

    //Fast solution for larger numbers
    public static long solution2() {
        long i = 1000;
        long triangleNum = (i * (i + 1)) / 2;
        TreeSet<Long> primeNums = Util.getPrimeNumsByCount(100000);
        while (true) {
            long size;
            i++;
            triangleNum = triangleNum + i;
            size = Util.getFactorCount(triangleNum, primeNums);

            //System.out.println(i + "\t" + triangleNum + "\t" + size);
            if (size > 500) {
                //System.out.println(i + "\t" + triangleNum + "\t" + size);
                return triangleNum;
            }
        }
    }
}
