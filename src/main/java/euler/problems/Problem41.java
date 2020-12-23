package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/8/12
 */
public class Problem41 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        double limit = Math.sqrt((double) 987654321);
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit((int) limit);
        ArrayList<String> lexicographicPermutations;
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
        while (numbers.size() > 0) {
            lexicographicPermutations = Util.getPermutations(numbers);
            for (int i = (lexicographicPermutations.size() - 1); i >= 0; i--) {
                long num = Long.parseLong(lexicographicPermutations.get(i));
                if (Util.isPrimeNumber(num, primeNums)) {
                    return num;
                }
            }
            int lastIndex = numbers.size() - 1;
            numbers.remove(lastIndex);
        }
        return 0;
    }
}
