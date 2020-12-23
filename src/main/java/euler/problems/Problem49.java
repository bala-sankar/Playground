package euler.problems;

import euler.utils.Util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/23/12
 */
public class Problem49 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static String solution1() {
        TreeSet<Long> primeNums = Util.getPrimeNumsByLimit(10000);
        for (long primeNum : primeNums) {
            if (primeNum > 999) {
                HashSet<String> permutations = new HashSet<String>();
                ArrayList<String> digits = Util.getDigitsString(primeNum);
                ArrayList<String> permutationList = Util.getPermutations(digits);
                permutations.addAll(permutationList);
                /*for(String permutation : permutations){
                    Long num = Long.valueOf(permutation);
                    if(num > 999 && primeNums.contains(num)){
                        count++;
                    }
                    if(count == 3) {
                        //System.out.println(primeNum);
                        break;
                    }
                }*/
                boolean rule1 = primeNums.contains(Long.valueOf(primeNum + 3330));
                boolean rule2 = permutations.contains(String.valueOf(primeNum + 3330));
                boolean rule3 = primeNums.contains(Long.valueOf(primeNum + 6660));
                boolean rule4 = permutations.contains(String.valueOf(primeNum + 6660));
                if (rule1 && rule2 && rule3 && rule4 && primeNum != 1487) {
                    return String.valueOf(primeNum) + String.valueOf(primeNum + 3330) + String.valueOf(primeNum + 6660);
                }

            }
        }
        return "";
    }
}
