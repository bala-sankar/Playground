package euler.problems;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 12/4/11
 */
/*
2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 */
public class Problem5 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static long solution1() {
        int[] primeNumbers = new int[]{19, 17, 13, 11, 7, 5, 3, 2};
        int[] num = new int[20];
        for (int i = 0; i < 20; i++) {
            num[i] = i + 1;
        }
        long result = 1;
        for (int i = 0; i < 8; i++) {
            boolean flag;
            do {
                flag = false;
                for (int j = 0; j < 20; j++) {
                    if (num[j] != 1 && num[j] % primeNumbers[i] == 0) {
                        num[j] = num[j] / primeNumbers[i];
                        flag = true;
                    }
                }
                if (flag) {
                    result = result * primeNumbers[i];
                }
            } while (flag);
        }
        return result;
    }
}
