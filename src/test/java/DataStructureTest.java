import datastructure.queue.Deque;
import datastructure.queue.DequeImpl;
import datastructure.queue.Queue;
import datastructure.queue.QueueImpl;
import datastructure.stack.Stack;
import datastructure.stack.StackImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 30, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@Execution(value = ExecutionMode.CONCURRENT)
public class DataStructureTest {
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
        System.out.println("Time took to run all the tests in DataStructureTest:\t" + elapsedTime);
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
    public void stackTest() {
        Stack<String> items = new StackImpl<String>();
        assertTrue(items.isEmpty());
        items.push("Hello");
        assertEquals("Hello", items.peep());
        items.push("World");
        assertEquals("World", items.peep());
        assertEquals("World", items.pop());
        assertEquals("Hello", items.peep());
        assertEquals(1, items.size());
    }

    @Test
    public void queueTest() {
        Queue<String> items = new QueueImpl<String>();
        assertTrue(items.isEmpty());
        items.enqueue("Hello");
        items.enqueue("World");
        assertFalse(items.isEmpty());
        assertEquals(2, items.size());
        assertEquals("Hello", items.dequeue());
        assertEquals(1, items.size());
    }

    @Test
    public void dequeTest() {
        Deque<String> items = new DequeImpl<String>();
        assertTrue(items.isEmpty());
        items.addRear("Fun");
        items.addFront("Hello");
        items.addRear("World");
        assertEquals(3, items.size());
        assertEquals("Hello", items.removeFront());
        assertEquals("World", items.removeRear());
        assertEquals(1, items.size());
    }
}
