package educative;

import educative.twopointers.Palindrome;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwoPointers {
    private static long overallStartTime;

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

    @Test
    public void testPalindrome() {
        Assert.assertEquals(false, Palindrome.isPalindrome("abab"));
        Assert.assertEquals(true, Palindrome.isPalindrome("abba"));
        Assert.assertEquals(false, Palindrome.isPalindrome("aabcbabab"));
        Assert.assertEquals(true, Palindrome.isPalindrome("abcba"));
        Assert.assertEquals(false, Palindrome.isPalindrome(""));
    }
}
