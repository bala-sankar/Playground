package euler;

import euler.utils.Util;
import org.apache.commons.math3.fraction.BigFraction;
import org.junit.*;
import org.junit.rules.TestName;

import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/30/12
 */
public class UtilTest extends Util {
    private static final int TIMEOUT = 60000;
    private static long overallStartTime;
    @Rule
    public TestName name = new TestName();
    private long startTime;

    @BeforeClass
    public static void beforeTestClass() {
        overallStartTime = System.currentTimeMillis();
    }

    @AfterClass
    public static void afterTestClass() {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - overallStartTime) / 1000.0;
        System.out.println("Time took to run all the tests in UtilTest:\t" + elapsedTime);
    }

    @Before
    public void beforeTest() {
        startTime = System.currentTimeMillis();
    }

    @After
    public void afterTest() {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - startTime) / 1000.0;
        System.out.println("Time took to run " + name.getMethodName() + ":\t" + elapsedTime);
    }

    @Test(timeout = TIMEOUT)
    public void findXTest() {
        long c = 52, p = 1;
        long expected = 2;
        long x = findX(c, p);
        Assert.assertEquals(expected, x);

        c = 11900;
        p = 141;
        expected = 4;
        x = findX(c, p);
        Assert.assertEquals(expected, x);
    }

    @Test(timeout = TIMEOUT)
    public void sqrtForBigNumTest() {
        String root = sqrtForBigNum("2");
        Assert.assertEquals("1.4142135", root);

        root = sqrtForBigNum("4");
        Assert.assertEquals("2.0000000", root);
    }

    @Test(timeout = TIMEOUT)
    public void getContinuedFractionsTest() {
        //String f = getContinuedFractions(13);
        String[] continuedFraction = Util.getContinuedFractions(7).split(";");
        int a = Integer.parseInt(continuedFraction[0]);
        String[] periods = continuedFraction[1].split(",");
        BigFraction temp = getConvergent(0, periods, a);
        Assert.assertEquals("2~1", temp.getNumerator() + "~" + temp.getDenominator());
    }

/*    @Test(timeout = TIMEOUT)
    public void getFactorCountTest() {
        TreeSet<Long> primeNums = Util.getPrimeNumsByCount(20);
        for (int i = 2; i <= 12; i++) {
            //System.out.println(i+"~"+getFactorCount(i, primeNums));
        }
    }*/

    @Test(timeout = TIMEOUT)
    public void getCombinationTest() {
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        ArrayList<String> combinations = getCombination(numbers, 3);
        Assert.assertEquals(4, combinations.size());
        combinations = getCombination(numbers, 2);
        Assert.assertEquals(6, combinations.size());
    }

    @Test(timeout = TIMEOUT)
    public void getPermutationTest() {
        ArrayList<String> numbers = new ArrayList<String>();
        numbers.add("0");
        numbers.add("1");
        numbers.add("2");
        numbers.add("3");
        ArrayList<String> permutations = getPermutations(numbers, 3);
        Assert.assertEquals(24, permutations.size());
    }

    @Test(timeout = TIMEOUT)
    public void isPalindromeTest() {
        Assert.assertTrue(isPalindrome(1001));
        Assert.assertFalse(isPalindrome(1002));
    }

    @Test(timeout = TIMEOUT)
    public void gcdTest() {
        Assert.assertEquals(gcd(7, 18), 1);
        Assert.assertEquals(gcd(8,18), 2);

    }
}
