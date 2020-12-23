package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/12/11
 */
public class Problem14 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //HashMap<Long, Long> func = new HashMap<Long, Long>();
        long maxChain = 0;
        long numWithMaxChain = 0;
        for (long i = 1; i < 1000000; i++) {
            long curVal = i, chain = 1;
            while (curVal != 1) {
                curVal = getVal(curVal);
                chain++;
            }
            if (chain > maxChain) {
                //System.out.println("New max chain; " + i + "\t" + chain);
                maxChain = chain;
                numWithMaxChain = i;
            }
        }
        return numWithMaxChain;
    }

    private static long getVal(long i) {
        if (i % 2 == 0) {
            return (i / 2);
        } else {
            return (3 * i) + 1;
        }
    }
}
