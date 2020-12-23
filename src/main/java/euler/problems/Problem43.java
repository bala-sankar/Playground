package euler.problems;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/10/12
 */
public class Problem43 {
    private static int[] divisors = {2, 3, 5, 7, 11, 13, 17};
    private static long sum = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //ArrayList<String> lexicographicPermutations;
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        numbers.add("4");
        numbers.add("5");
        numbers.add("6");
        numbers.add("7");
        numbers.add("8");
        numbers.add("9");
        /*lexicographicPermutations = Util.getPermutations(numbers);

        long sum = 0;
        for (String lexicographicPermutation : lexicographicPermutations) {
            //char[] digits = lexicographicPermutation.toCharArray();
            boolean isSubStringDivisible = true;
            for (int i = 0; i < 7; i++) {
                *//*String num = Character.toString(digits[i + 1]) + Character.toString(digits[i + 2]) +
                        Character.toString(digits[i + 3]);*//*
                String num = lexicographicPermutation.substring(i+1, i+3);
                if (Integer.valueOf(num) % divisors[i] != 0) {
                    isSubStringDivisible = false;
                    break;
                }
            }
            if (isSubStringDivisible) {
                sum = sum + Long.valueOf(lexicographicPermutation);
            }
        }*/
        permutation(numbers, "", numbers.size(), 0);
        return sum;
    }

    protected static void permutation(ArrayList<String> numbers, String num,
                                      int length, int loop) {
        if (loop == length) {
            boolean isSubStringDivisible = true;
            for (int i = 0; i < 7; i++) {
                /*String num = Character.toString(digits[i + 1]) + Character.toString(digits[i + 2]) +
                        Character.toString(digits[i + 3]);*/
                if (Integer.valueOf(num.substring(i+1, i+4)) % divisors[i] != 0) {
                    isSubStringDivisible = false;
                    break;
                }
            }
            if (isSubStringDivisible) {
                sum = sum + Long.valueOf(num);
            }
            return;
        }
        for (String number : numbers) {
            ArrayList<String> temp = new ArrayList<String>();
            temp.addAll(numbers);
            temp.remove(number);
            permutation(temp, num + number, length, loop + 1);
        }
    }
}
