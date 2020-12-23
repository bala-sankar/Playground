package euler.problems;

import java.math.BigInteger;
import java.util.HashSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/20/12
 */
public class Problem29 {
    public static void main(String[] args) {
        System.out.println("Result is : " + solution1());
    }

    public static long solution1() {
        HashSet<String> distinctNums = new HashSet<String>();
        for (int a = 2; a <= 100; a++) {
            for (int b = 2; b <= 100; b++) {
                BigInteger i = new BigInteger(String.valueOf(a));
                distinctNums.add(i.pow(b).toString());
            }
        }
        return distinctNums.size();
    }
}
