import algorithm.BubbleSort;
import algorithm.InsertionSort;
import algorithm.MergeSort;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * Created by bsankar on 8/9/14.
 */
public class AlgorithmTest {
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
    public void insertionSortTest() {
        int[] unsortedArray = new int[] {5,2,4,6,1,3};
        InsertionSort.sort(unsortedArray);
        int[] expectedSortedArray = new int[] {1,2,3,4,5,6};
        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
        unsortedArray = new int[] {31, 41, 59, 26, 41, 58};
        expectedSortedArray = new int[]{26, 31, 41, 41, 58, 59};
        InsertionSort.sort(unsortedArray);
        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void mergeSortTest() {
        int[] unsortedArray = new int[] {5,2,4,6,1,3};
        MergeSort.sort(unsortedArray);
        int[] expectedSortedArray = new int[] {1,2,3,4,5,6};
        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
        unsortedArray = new int[] {31, 41, 59, 26, 41, 58};
        expectedSortedArray = new int[]{26, 31, 41, 41, 58, 59};
        MergeSort.sort(unsortedArray);
        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test(timeout = TIMEOUT)
    public void bubbleSortTest() {
        int[] unsortedArray = new int[] {5,2,4,6,1,3};
        BubbleSort.sort(unsortedArray);
        int[] expectedSortedArray = new int[] {1,2,3,4,5,6};
        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);
        unsortedArray = new int[] {31, 41, 59, 26, 41, 58};
        expectedSortedArray = new int[]{26, 31, 41, 41, 58, 59};
        BubbleSort.sort(unsortedArray);
        Assert.assertArrayEquals(expectedSortedArray, unsortedArray);

    }
}
