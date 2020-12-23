package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 7/3/12
 */
public class Problem76 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int limit = 100;
        int numLength = limit - 1;
        int[] numbers = new int[numLength];
        for (int i = 1; i <= numLength; i++) {
            numbers[i - 1] = i;
        }

        int[] ways = new int[limit + 1];
        ways[0] = 1;
        for (int number : numbers) {
            for (int t = number; t <= limit; t++) {
                ways[t] = ways[t] + ways[t - number];
            }
        }
        return ways[limit];
    }
}
