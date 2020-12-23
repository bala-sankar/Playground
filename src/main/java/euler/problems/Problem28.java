package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/20/12
 */
public class Problem28 {
    public static void main(String[] args) {
        System.out.println("Result is : " + solution1());
    }

    public static long solution1() {
        long sum = 0;
        for (long i = 1001; i > 1; i = i - 2) {
            /*long e1 = i*i;
            long e2 = ((i-1)*(i-1))+1;
            long e3 = e1-(i-1);
            long e4 = e2-(i-1);*/
            //Derived equation from e1,e2,e3,e4
            long eq = (4 * (i * i)) - (6 * i) + 6;
            sum = sum + eq;
        }
        return sum + 1;
    }
}
