package euler.problems;

import euler.utils.Util;

import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/10/12
 */
public class Problem44 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //Considering first 10,000 Pentagonal numbers
        TreeSet<Long> pentagonalNums = Util.getPentagonalNumbersByCount(10000);
        NavigableSet<Long> Num1 = pentagonalNums.descendingSet();
        NavigableSet<Long> Num2 = new TreeSet<Long>();
        Num2.addAll(Num1);
        for (long a : Num1) {
            Num2.remove(Long.valueOf(a));
            for (long b : Num2) {
                long sum = a + b;
                long diff = a - b;
                if (Util.isPentagonalNumber(sum) && Util.isPentagonalNumber(diff)) {
                    //System.out.println(a+"\t"+b+"\t"+ sum+"\t"+ pentagonalNums.contains(sum));
                    //System.out.println(a+"\t"+b+"\t"+ diff+"\t"+pentagonalNums.contains(diff));
                    return diff;
                }
            }

        }
        return 0;
    }
}
