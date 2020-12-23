package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/12/11
 */
public class Problem15 {
    private static final long row = 20;
    private static final long column = 20;
    private static long routes = 0;

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        //start from 0,0
        //Optimization, route(0,0) = 2 * route(1,0)
        route(1, 0);
        return (routes * 2);
    }

    private static void route(int i, int j) {
        //Optimization
        if (i == row - 2) {
            long n = (column - j + 1);
            routes = routes + ((n * (n + 1)) / 2);
            return;
        }

        if (j == column - 2) {
            long n = (row - i + 1);
            routes = routes + ((n * (n + 1)) / 2);
            return;
        }

        if (j < (column - 2)) {
            //Move right
            route(i, j + 1);
        }

        if (i < (row - 2)) {
            //move Down
            route(i + 1, j);
        }
    }
}
