package euler.problems;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/16/11
 */
public class Problem24 {
    private static int count = 0;
    private static int n = 1000000;
    private static String result = "";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static String solution1() {
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
        //lexicographicPermutations = Util.getPermutations(numbers);
        permutation(numbers, "", numbers.size(), 0);
        //return lexicographicPermutations.get(999999);
        return result;
    }

    protected static void permutation(ArrayList<String> numbers, String num,
                                      int length, int loop) {
        if(count == n){
            return;
        }
        if (loop == length) {
            count++;
            if(count == n){
                result = num;
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
