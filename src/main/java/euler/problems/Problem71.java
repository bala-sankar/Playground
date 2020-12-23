package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 6/6/12
 */
public class Problem71 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        double minFrac = 0.0;
        double threeBySeven = 3.0 / 7.0;
        int numerator = 0;
        for (int d = 1; d <= 1000000; d++) {
            for (int n = (int) (minFrac * d); n <= (int) (threeBySeven * d); n++) {
                double temp = (double) n / (double) d;
                //System.out.println(n + "/" + d + "~" + temp.toString());
                if (temp < threeBySeven && minFrac < temp) {
                    //System.out.println(n + "/" + d + "~" + temp.toString());
                    minFrac = temp;
                    numerator = n;
                }
            }
        }
        //System.out.println(threeBySeven.toString());
        return numerator;
    }
}
