package educative;

import educative.twopointers.Palindrome;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@Execution(value = ExecutionMode.CONCURRENT)
public class TwoPointersTest {
    private static long overallStartTime;

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

    @Test
    public void testPalindrome() {
        assertFalse(Palindrome.isPalindrome("abab"));
        assertTrue(Palindrome.isPalindrome("abba"));
        assertFalse(Palindrome.isPalindrome("aabcbabab"));
        assertTrue(Palindrome.isPalindrome("abcba"));
        assertFalse(Palindrome.isPalindrome(""));
    }
}
