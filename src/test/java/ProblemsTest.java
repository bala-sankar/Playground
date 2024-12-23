import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import problems.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@Execution(value = ExecutionMode.CONCURRENT)
public class ProblemsTest {
    private static final int TIMEOUT = 60000;
    private static long overallStartTime;

    private long startTime;

    @BeforeAll
    public static void BeforeTestClass() {
        overallStartTime = System.currentTimeMillis();
    }

    @AfterAll
    public static void AfterTestClass() {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - overallStartTime) / 1000.0;
        System.out.println("Time took to run all the tests in ProblemTest:\t" + elapsedTime);
    }

    @BeforeEach
    public void BeforeTest() {
        startTime = System.currentTimeMillis();
    }

    @AfterEach
    public void AfterTest(TestInfo testInfo) {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - startTime) / 1000.0;
        System.out.println("Time took to run " + testInfo.getDisplayName() + ":\t" + elapsedTime);
    }

    @Test
    public void parenthesesTest() {
        assertTrue(Parentheses.check("{(a+[b+c])+d}"));
        assertFalse(Parentheses.check("{(a+[b+c]+d})"));
        assertFalse(Parentheses.check("{(a+[b+c]+d"));
    }

    @Test
    public void palindromeTest() {
        assertTrue(Palindrome.check("mom"));
        assertFalse(Palindrome.check("cat"));
        assertFalse(Palindrome.check("Mom"));
    }

    @Test
    public void oddEvenJumpTest() {
        int[] testData1 = new int[] {10,13,12,14,15};
        assertEquals(2, OddEvenJump.oddEvenJumps(testData1));
        int[] testData2 = new int[] {5,1,3,4,2};
        assertEquals(3, OddEvenJump.oddEvenJumps(testData2));
//        int[] testData3 = new int[] {44,22,11,55,55};
//        assertEquals(3, OddEvenJump.oddEvenJumps(testData3));
    }

    @Test
    public void licenseKeyFormattingTest() {
        assertEquals("5F3Z-2E9W", LicenseKeyFormatting.format("5F3Z-2e-9-w", 4));
        assertEquals("AA-AA", LicenseKeyFormatting.format("--a-a-a-a--", 2));
    }

    @Test
    public void longestSubstringTest() {
        assertEquals(3, LongestSubstring.length("abcabcbb"));
    }

//    @Test
//    public void longestSubstringTest() {
//        assertEquals(3, LongestSubstring.length("abcabcbb"));
//    }
}
