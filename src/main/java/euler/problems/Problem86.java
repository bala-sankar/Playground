package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 10/2/12
 */
public class Problem86 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long count = 0;
        for (int m = 1; ; m++) {
            for (int w = 1; w <= m; w++) {
                for (int h = w; h <= m; h++) {
                    int len = w + h;
                    double shortPath = Math.sqrt((m * m) + (len * len));
                    if (shortPath == (double) (long) shortPath) {
                        count++;
                    }
                }
            }
            if (count > 1000000) {
                return m;
            }
        }
    }
}
