import algorithm.BubbleSort;
import algorithm.InsertionSort;
import algorithm.MergeSort;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * Created by bsankar on 8/9/14.
 */
@Timeout(value = 30, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@Execution(value = ExecutionMode.CONCURRENT)
public class AlgorithmTest {
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
    public void insertionSortTest() {
        int[] unsortedArray = new int[] {5,2,4,6,1,3};
        InsertionSort.sort(unsortedArray);
        int[] expectedSortedArray = new int[] {1,2,3,4,5,6};
        assertArrayEquals(expectedSortedArray, unsortedArray);
        unsortedArray = new int[] {31, 41, 59, 26, 41, 58};
        expectedSortedArray = new int[]{26, 31, 41, 41, 58, 59};
        InsertionSort.sort(unsortedArray);
        assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void mergeSortTest() {
        int[] unsortedArray = new int[] {5,2,4,6,1,3};
        MergeSort.sort(unsortedArray);
        int[] expectedSortedArray = new int[] {1,2,3,4,5,6};
        assertArrayEquals(expectedSortedArray, unsortedArray);
        unsortedArray = new int[] {31, 41, 59, 26, 41, 58};
        expectedSortedArray = new int[]{26, 31, 41, 41, 58, 59};
        MergeSort.sort(unsortedArray);
        assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void bubbleSortTest() {
        int[] unsortedArray = new int[] {5,2,4,6,1,3};
        BubbleSort.sort(unsortedArray);
        int[] expectedSortedArray = new int[] {1,2,3,4,5,6};
        assertArrayEquals(expectedSortedArray, unsortedArray);
        unsortedArray = new int[] {31, 41, 59, 26, 41, 58};
        expectedSortedArray = new int[]{26, 31, 41, 41, 58, 59};
        BubbleSort.sort(unsortedArray);
        assertArrayEquals(expectedSortedArray, unsortedArray);

    }
}
