package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/12/12
 */
public class Problem58 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        long count = 0;

        long totalCorners = 1;
        for (long i = 3; ; i = i + 2) {
            //Edges of a spiral
            long e1 = i * i;                  //9
            long e2 = ((i - 1) * (i - 1)) + 1;      //5
            long e3 = e1 - (i - 1);             //7
            long e4 = e2 - (i - 1);             //3

            /*long last = primeNum.last();
            if(e1 > last || e2 > last || e3 > last || e4 > last) {
                System.out.println("Problem");
            }*/

            /*if(primeNum.contains(new Long(e1))){
                count++;
            }*/
            if (euler.utils.Util.isPrimeNumber(e2)) {
                count++;
            }
            if (euler.utils.Util.isPrimeNumber(e3)) {
                count++;
            }
            if (euler.utils.Util.isPrimeNumber(e4)) {
                count++;
            }
            totalCorners = totalCorners + 4;
            double ratio = ((double) count / (double) totalCorners);
            if (ratio < 0.10) {
                return i;
            }

        }
    }


}
