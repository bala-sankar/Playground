package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 2/28/12
 */
public class Problem53 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long count = 0;
        /*
         * nC0 = 1
         * nC1 = n
         * nCn = 1
         */
        for (int n = 23; n <= 100; n++) {
            for (int r = 0; r < n; r++) {
                long numerator = 1;
                long denominator = 1;
                int tempN = n;
                int tempR = 1;
                for (int i = 0; i < r; i++) {
                    numerator = numerator * tempN;
                    denominator = denominator * tempR;
                    tempR++;
                    tempN--;
                }
                if ((numerator / denominator) > 1000000) {
                    /*
                     * 5C0=1, 5C1=5, 5C2=10, 5C3=10, 5C4=5, 5C5=1
                     * Similarly, 4C0=1, 4C1=4,4C2=6, 4C3=4, 4C4=1
                     * From above, We conclude the combination for a number n is symmetrical
                     * Hence, when we find the first nCr which is above 1 million,
                     * then we can calculate the number of nCr (which has more than 1 million combinations)
                     * using the formula below
                     * count = (n+1)-(2*r)
                     * For example, To find all 5Cr which has more than 4 combinations
                     * When we reach, 5C1 the combinations are 5.
                     * Hence, count = (5+1)-(2*1)
                     * count = 6 - 2
                     * count = 4
                     */
                    long tempCount = (n + 1) - (2 * r);
                    count = count + tempCount;
                    break;
                }
            }
        }
        return count;
    }
}
