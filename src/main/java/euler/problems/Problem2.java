package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/3/11
 */
public class Problem2 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution2());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long i = 1, j = 1, k = 1, sum = 0;
        while (k <= 4000000) {
            if (k % 2 == 0) {
                sum = sum + k;
            }
            k = i + j;
            j = i;
            i = k;
        }
        return sum;
    }

    public static long solution2() {
        long i = 1, j = 1, k, sum = 0;
        k = i + j;
        while (k <= 4000000) {
            sum = sum + k;
            i = j + k;
            j = k + i;
            k = i + j;
        }
        return sum;
    }
}
