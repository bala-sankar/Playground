package euler.problems;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/13/12
 */
public class Problem60 {
    private static final int window = 5;


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int limit = 10000;
        ArrayList<String> num = new ArrayList<String>();
        TreeSet<Long> primeNums = euler.utils.Util.getPrimeNumsByLimit(limit);
        primeNums.remove(Long.valueOf(2));
        primeNums.remove(Long.valueOf(5));
        return RemarkablePrime(primeNums, num);
    }

    private static long RemarkablePrime(TreeSet<Long> primeNums, ArrayList<String> num) {
        if (num.size() == window) {
            long sum = 0;
            for (String number : num) {
                sum = sum + Long.parseLong(number);
            }
            return sum;
        } else {
            TreeSet<Long> temp = new TreeSet<Long>();
            temp.addAll(primeNums);
            ArrayList<String> tempNum = new ArrayList<String>();
            tempNum.addAll(num);
            for (long primeNum : primeNums) {
                tempNum.add(String.valueOf(primeNum));
                temp.remove(primeNum);
                if (tempNum.size() > 1 && !isRemarkablePrime(tempNum)) {
                    tempNum.remove(String.valueOf(primeNum));
                    continue;
                }
                long sum = RemarkablePrime(temp, tempNum);
                if (sum != 0) {
                    return sum;
                }
                tempNum.remove(String.valueOf(primeNum));
            }

        }
        return 0;
    }

    private static boolean isRemarkablePrime(ArrayList<String> num) {
        boolean isSetOfRemarkablePrime = true;
        ArrayList<String> permutations = euler.utils.Util.getPermutations(num, 2);
        for (String permutation : permutations) {
            long n = Long.parseLong(permutation);
            if (!euler.utils.Util.isPrimeNumber(n)) {
                isSetOfRemarkablePrime = false;
                break;
            }
        }
        return isSetOfRemarkablePrime;
    }
}

