package euler.problems;

import java.util.TreeSet;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/23/12
 */
public class Problem31 {
    private static long totalCombinations = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        /*System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();*/
        System.out.println("Result is : " + solution2());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        TreeSet<Integer> currencies = new TreeSet<Integer>();
        currencies.add(1);
        currencies.add(2);
        currencies.add(5);
        currencies.add(10);
        currencies.add(20);
        currencies.add(50);
        currencies.add(100);
        currencies.add(200);
        combination(currencies, 200, "");
        return totalCombinations;
    }

    public static long solution2() {

        int limit = 200;
        TreeSet<Integer> currencies = new TreeSet<Integer>();
        currencies.add(1);
        currencies.add(2);
        currencies.add(5);
        currencies.add(10);
        currencies.add(20);
        currencies.add(50);
        currencies.add(100);
        currencies.add(200);

        int[] ways = new int[limit + 1];
        ways[0] = 1;
        for (int currency : currencies) {
            for (int t = currency; t <= limit; t++) {
                ways[t] = ways[t] + ways[t - currency];
            }
        }
        return ways[limit];
    }

    private static void combination(TreeSet<Integer> numbers, int limit, String combination) {
        TreeSet<Integer> tempNumber = new TreeSet<Integer>();
        tempNumber.addAll(numbers);
        for (int number : numbers) {
            int tempLimit = limit - number;
            if (tempLimit == 0) {
                //System.out.println(temp);
                totalCombinations++;
            } else if (tempLimit > 0) {
                //System.out.print(currency + " ");
                String temp = combination + " " + number;
                combination(tempNumber, tempLimit, temp);
                tempNumber.remove(Integer.valueOf(number));
            }
        }
    }
}
