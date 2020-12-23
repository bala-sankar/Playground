package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/4/11
 */
public class Problem6 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int num = 100;
        return SquareOfSum(num) - SumOfSquares(num);
    }

    private static long SumOfSquares(int num) {
        long sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + (i * i);
        }
        //System.out.println("SumOfSquares is : " + sum);
        return sum;
    }

    private static long SquareOfSum(int num) {
        long sum = ((num * (num + 1)) / 2);
        sum = sum * sum;
        //System.out.println("SquareOfSum is : " + sum);
        return sum;
    }
}
