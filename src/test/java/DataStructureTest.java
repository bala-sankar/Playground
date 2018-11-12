import data_structure.stack.Stack;
import data_structure.stack.StackImpl;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class DataStructureTest {
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
        System.out.println("Time took to run all the tests in DataStructureTest:\t" + elapsedTime);
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
    public void stackTest() {
        Stack<String> items = new StackImpl<String>();
        Assert.assertEquals(items.isEmpty(), true);
        items.push("Hello");
        Assert.assertEquals(items.peep(), "Hello");
        items.push("World");
        Assert.assertEquals(items.peep(), "World");
        Assert.assertEquals(items.pop(), "World");
        Assert.assertEquals(items.peep(), "Hello");
        Assert.assertEquals(items.size(), 1);
    }
}
