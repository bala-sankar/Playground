package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 11/15/12
 */
public class Problem97 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //28433 * (2 pow 7830457)+1
        long result = 28433;
        for (long i = 1; i <= 7830457; i++) {
            result = (result * 2) % 10000000000L;
        }
        return ((result + 1) % 10000000000L);
    }
}
