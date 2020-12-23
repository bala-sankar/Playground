package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/6/11
 */
public class Problem9 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
        startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution2());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int c, b, a;
        int s = 1000;
        for (c = s / 3; c < s; c++) {
            for (b = ((s - c) / 2) + 1; b < (s - c); b++) {
                a = (s - c - b);
                if ((a * a + b * b) == (c * c)) {
                    //System.out.println("a, b, c : " + a + ", " + b + ", " + c);
                    return (a * b * c);
                }
            }
        }
        return 0;
    }

    public static long solution2() {
        int c, b, a;
        int s = 1000;
        for (a = 3; a < s / 3; a++) {
            for (b = a + 1; b < ((s - a) / 2); b++) {
                c = (s - a - b);
                if ((a * a + b * b) == (c * c)) {
                    //System.out.println("a, b, c : " + a + ", " + b + ", " + c);
                    return (a * b * c);
                }
            }
        }
        return 0;
    }
}
