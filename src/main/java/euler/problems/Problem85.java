package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 8/20/12
 */
public class Problem85 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        double limit = 2000000;
        /*
         * 'r' is the number of rows and 'c' is the number of columns in the grid
         * The formula to calculate the number of rectangles in the grid,
         *      [(r*(r+1))/2]*[(c*(c+1))/2] = X, which is then total number of rectangles from the grid
         */
        long maxRectangles = 0;
        long area = 0;
        for (int c = 2000; c >= 1; c--) {
            for (int r = 1; r <= c; r++) {
                long rectangles = ((r * (r + 1)) / 2) * ((c * (c + 1)) / 2);
                if (rectangles > limit) {
                    break;
                }
                if (rectangles > maxRectangles) {
                    maxRectangles = rectangles;
                    area = r * c;
                    //System.out.println(r+"\t"+c+"\t"+area+"\t"+rectangles);
                }
            }
        }
        return area;
    }
}
