import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import euler.problems.Palindrome;
import euler.problems.Parentheses;

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
}
