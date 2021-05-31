import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import problems.*;

public class ProblemsTest {
    private static final int TIMEOUT = 60000;
    private static long overallStartTime;
    @Rule
    public TestName name = new TestName();
    private long startTime;

    @BeforeClass
    public static void BeforeTestClass() {
        overallStartTime = System.currentTimeMillis();
    }

    @AfterClass
    public static void AfterTestClass() {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - overallStartTime) / 1000.0;
        System.out.println("Time took to run all the tests in ProblemTest:\t" + elapsedTime);
    }

    @Before
    public void BeforeTest() {
        startTime = System.currentTimeMillis();
    }

    @After
    public void AfterTest() {
        long stopTime = System.currentTimeMillis();
        double elapsedTime = (stopTime - startTime) / 1000.0;
        System.out.println("Time took to run " + name.getMethodName() + ":\t" + elapsedTime);
    }

    @Test(timeout = TIMEOUT)
    public void parenthesesTest() {
        Assert.assertTrue(Parentheses.check("{(a+[b+c])+d}"));
        Assert.assertFalse(Parentheses.check("{(a+[b+c]+d})"));
        Assert.assertFalse(Parentheses.check("{(a+[b+c]+d"));
    }

    @Test(timeout = TIMEOUT)
    public void palindromeTest() {
        Assert.assertTrue(Palindrome.check("mom"));
        Assert.assertFalse(Palindrome.check("cat"));
        Assert.assertFalse(Palindrome.check("Mom"));
    }

    @Test(timeout = TIMEOUT)
    public void oddEvenJumpTest() {
        int[] testData1 = new int[] {10,13,12,14,15};
        Assert.assertEquals(2, OddEvenJump.oddEvenJumps(testData1));
        int[] testData2 = new int[] {5,1,3,4,2};
        Assert.assertEquals(3, OddEvenJump.oddEvenJumps(testData2));
//        int[] testData3 = new int[] {44,22,11,55,55};
//        Assert.assertEquals(3, OddEvenJump.oddEvenJumps(testData3));
    }

    @Test(timeout = TIMEOUT)
    public void licenseKeyFormattingTest() {
        Assert.assertEquals("5F3Z-2E9W", LicenseKeyFormatting.format("5F3Z-2e-9-w", 4));
        Assert.assertEquals("AA-AA", LicenseKeyFormatting.format("--a-a-a-a--", 2));
    }

    @Test(timeout = TIMEOUT)
    public void longestSubstringTest() {
        Assert.assertEquals(3, LongestSubstring.length("abcabcbb"));
    }

//    @Test(timeout = TIMEOUT)
//    public void longestSubstringTest() {
//        Assert.assertEquals(3, LongestSubstring.length("abcabcbb"));
//    }
}
