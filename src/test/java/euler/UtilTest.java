package euler;

import euler.utils.Util;
import org.apache.commons.math3.fraction.BigFraction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/30/12
 */
@Timeout(value = 30, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@Execution(value = ExecutionMode.CONCURRENT)
public class UtilTest extends Util {
    private static final int TIMEOUT = 60000;
    private static long overallStartTime;

    private long startTime;

    @BeforeAll
    public static void beforeTestClass() {
        overallStartTime = System.currentTimeMillis();
    }

    @AfterAll
    public static void afterTestClass() {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - overallStartTime) / 1000.0;
        System.out.println("Time took to run all the tests in UtilTest:\t" + elapsedTime);
    }

    @BeforeEach
    public void beforeTest() {
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    public void afterTest(TestInfo testInfo) {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - startTime) / 1000.0;
        System.out.println("Time took to run " + testInfo.getDisplayName() + ":\t" + elapsedTime);
    }

    @Test
    public void findXTest() {
        long c = 52, p = 1;
        long expected = 2;
        long x = findX(c, p);
        assertEquals(expected, x);

        c = 11900;
        p = 141;
        expected = 4;
        x = findX(c, p);
        assertEquals(expected, x);
    }

    @Test
    public void sqrtForBigNumTest() {
        String root = sqrtForBigNum("2");
        assertEquals("1.4142135", root);

        root = sqrtForBigNum("4");
        assertEquals("2.0000000", root);
    }

    @Test
    public void getContinuedFractionsTest() {
        //String f = getContinuedFractions(13);
        String[] continuedFraction = Util.getContinuedFractions(7).split(";");
        int a = Integer.parseInt(continuedFraction[0]);
        String[] periods = continuedFraction[1].split(",");
        BigFraction temp = getConvergent(0, periods, a);
        assertEquals("2~1", temp.getNumerator() + "~" + temp.getDenominator());
    }

/*    @Test
    public void getFactorCountTest() {
        TreeSet<Long> primeNums = Util.getPrimeNumsByCount(20);
        for (int i = 2; i <= 12; i++) {
            //System.out.println(i+"~"+getFactorCount(i, primeNums));
        }
    }*/

    @Test
    public void getCombinationTest() {
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        ArrayList<String> combinations = getCombination(numbers, 3);
        assertEquals(4, combinations.size());
        combinations = getCombination(numbers, 2);
        assertEquals(6, combinations.size());
    }

    @Test
    public void getPermutationTest() {
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        ArrayList<String> permutations = getPermutations(numbers, 3);
        assertEquals(24, permutations.size());
    }

    @Test
    public void isPalindromeTest() {
        assertTrue(isPalindrome(1001));
        assertFalse(isPalindrome(1002));
    }

    @Test
    public void gcdTest() {
        assertEquals(1, gcd(7, 18));
        assertEquals(2, gcd(8,18));

    }
}
