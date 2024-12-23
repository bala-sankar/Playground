package euler;

import euler.problems.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 1/30/12
 */
@Timeout(value = 30, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@Execution(value = ExecutionMode.CONCURRENT)
public class ProblemTest {
    private static final int TIMEOUT = 30000;
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
    public void Problem1Test() {
        long expected = 233168;
        assertEquals(expected, Problem1.solution1());
        assertEquals(expected, Problem1.solution2());
    }

    @Test
    public void Problem2Test() {
        long expected = 4613732;
        assertEquals(expected, Problem2.solution1());
        assertEquals(expected, Problem2.solution2());
    }

    @Test
    public void Problem3Test() {
        long expected = 6857;
        assertEquals(expected, Problem3.solution1());
        assertEquals(expected, Problem3.solution2());
    }

    @Test
    public void Problem4Test() {
        long expected = 906609;
        assertEquals(expected, Problem4.solution1());
    }

    @Test
    public void Problem5Test() {
        long expected = 232792560;
        assertEquals(expected, Problem5.solution1());
    }

    @Test
    public void Problem6Test() {
        long expected = 25164150;
        assertEquals(expected, Problem6.solution1());
    }

    @Test
    public void Problem7Test() {
        long expected = 104743;
        assertEquals(expected, Problem7.solution1());
    }

    @Test
    public void Problem8Test() {
        long expected = 40824;
        assertEquals(expected, Problem8.solution1());
    }

    @Test
    public void Problem9Test() {
        long expected = 31875000;
        assertEquals(expected, Problem9.solution1());
    }

    @Test
    public void Problem10Test() {
        long expected = 142913828922L;
        assertEquals(expected, Problem10.solution1());
    }

    @Test
    public void Problem11Test() {
        long expected = 70600674;
        assertEquals(expected, Problem11.solution1());
    }

    @Test
    public void Problem12Test() {
        long expected = 76576500;
        assertEquals(expected, Problem12.solution2());
    }

    @Test
    public void Problem13Test() {
        String expected = "5537376230";
        assertEquals(expected, Problem13.solution1());
    }

    @Test
    public void Problem14Test() {
        long expected = 837799;
        assertEquals(expected, Problem14.solution1());
    }

    @Test
    public void Problem15Test() {
        long expected = 137846528820L;
        assertEquals(expected, Problem15.solution1());
    }

    @Test
    public void Problem16Test() {
        long expected = 1366;
        assertEquals(expected, Problem16.solution1());
    }

    @Test
    public void Problem17Test() {
        long expected = 21124;
        assertEquals(expected, Problem17.solution1());
    }

    @Test
    public void Problem18Test() {
        long expected = 1074;
        assertEquals(expected, Problem18.solution1());
    }

    @Test
    public void Problem19Test() {
        long expected = 171;
        assertEquals(expected, Problem19.solution1());
    }

    @Test
    public void Problem20Test() {
        long expected = 648;
        assertEquals(expected, Problem20.solution1());
    }

    @Test
    public void Problem21Test() {
        long expected = 31626;
        assertEquals(expected, Problem21.solution1());
    }

    @Test
    public void Problem22Test() {
        long expected = 871198282;
        assertEquals(expected, Problem22.solution1());
    }

    @Test
    public void Problem23Test() {
        long expected = 4179871;
        assertEquals(expected, Problem23.solution1());
    }

    @Test
    public void Problem24Test() {
        String expected = "2783915460";
        assertEquals(expected, Problem24.solution1());
    }

    @Test
    public void Problem25Test() {
        long expected = 4782;
        assertEquals(expected, Problem25.solution1());
    }

    @Test
    public void Problem26Test() {
        long expected = 983;
        assertEquals(expected, Problem26.solution1());
    }

    @Test
    public void Problem27Test() {
        long expected = -59231;
        assertEquals(expected, Problem27.solution1());
    }

    @Test
    public void Problem28Test() {
        long expected = 669171001;
        assertEquals(expected, Problem28.solution1());
    }

    @Test
    public void Problem29Test() {
        long expected = 9183;
        assertEquals(expected, Problem29.solution1());
    }

    @Test
    public void Problem30Test() {
        long expected = 443839;
        assertEquals(expected, Problem30.solution1());
    }

    @Test
    public void Problem31Test() {
        long expected = 73682;
        assertEquals(expected, Problem31.solution2());
    }

    @Test
    public void Problem32Test() {
        long expected = 45228;
        assertEquals(expected, Problem32.solution1());
    }

    @Test
    public void Problem33Test() {
        long expected = 100;
        assertEquals(expected, Problem33.solution1());
    }

    @Test
    public void Problem34Test() {
        long expected = 40730;
        assertEquals(expected, Problem34.solution1());
    }

    @Test
    public void Problem35Test() {
        long expected = 55;
        assertEquals(expected, Problem35.solution1());
    }

    @Test
    public void Problem36Test() {
        long expected = 872187;
        assertEquals(expected, Problem36.solution1());
    }

    @Test
    public void Problem37Test() {
        long expected = 748317;
        assertEquals(expected, Problem37.solution1());
    }

    @Test
    public void Problem38Test() {
        long expected = 932718654;
        assertEquals(expected, Problem38.solution1());
    }

    @Test
    public void Problem39Test() {
        long expected = 840;
        assertEquals(expected, Problem39.solution1());
    }

    @Test
    public void Problem40Test() {
        long expected = 210;
        assertEquals(expected, Problem40.solution1());
    }

    @Test
    public void Problem41Test() {
        long expected = 7652413;
        assertEquals(expected, Problem41.solution1());
    }

    @Test
    public void Problem42Test() {
        long expected = 162;
        assertEquals(expected, Problem42.solution1());
    }

    @Test
    public void Problem43Test() {
        long expected = 16695334890L;
        assertEquals(expected, Problem43.solution1());
    }

    @Test
    public void Problem44Test() {
        long expected = 5482660;
        assertEquals(expected, Problem44.solution1());
    }

    @Test
    public void Problem45Test() {
        long expected = 1533776805;
        assertEquals(expected, Problem45.solution1());
    }

    @Test
    public void Problem46Test() {
        long expected = 5777;
        assertEquals(expected, Problem46.solution1());
    }

    @Test
    public void Problem47Test() {
        long expected = 134043;
        assertEquals(expected, Problem47.solution1());
    }

    @Test
    public void Problem48Test() {
        String expected = "9110846700";
        assertEquals(expected, Problem48.solution1());
    }

    @Test
    public void Problem49Test() {
        String expected = "296962999629";
        assertEquals(expected, Problem49.solution1());
    }

    @Test
    public void Problem50Test() {
        long expected = 997651;
        assertEquals(expected, Problem50.solution1());
    }

    @Test
    public void Problem51Test() {
        long expected = 121313;
        assertEquals(expected, Problem51.solution1());
    }

    @Test
    public void Problem52Test() {
        long expected = 142857;
        assertEquals(expected, Problem52.solution1());
    }

    @Test
    public void Problem53Test() {
        long expected = 4075;
        assertEquals(expected, Problem53.solution1());
    }

    @Test
    public void Problem54Test() {
        long expected = 376;
        assertEquals(expected, Problem54.solution1());
    }

    @Test
    public void Problem55Test() {
        long expected = 249;
        assertEquals(expected, Problem55.solution1());
    }

    @Test
    public void Problem56Test() {
        long expected = 972;
        assertEquals(expected, Problem56.solution1());
    }

    @Test
    public void Problem57Test() {
        long expected = 153;
        assertEquals(expected, Problem57.solution1());
    }

    @Test
    public void Problem58Test() {
        long expected = 26241;
        assertEquals(expected, Problem58.solution1());
    }

    @Test
    public void Problem59Test() {
        long expected = 107359;
        assertEquals(expected, Problem59.solution1());
    }

    @Test
    public void Problem60Test() {
        long expected = 26033;
        assertEquals(expected, Problem60.solution1());
    }


    @Test
    public void Problem61Test() {
        long expected = 28684;
        assertEquals(expected, new Problem61().solution1());
    }

    @Test
    public void Problem62Test() {
        long expected = 127035954683L;
        assertEquals(expected, Problem62.solution1());
    }

    @Test
    public void Problem63Test() {
        long expected = 49;
        assertEquals(expected, Problem63.solution1());
    }

    @Test
    public void Problem64Test() {
        long expected = 1322;
        assertEquals(expected, Problem64.solution1());
    }

    @Test
    public void Problem65Test() {
        long expected = 272;
        assertEquals(expected, Problem65.solution1());
    }

    @Test
    public void Problem66Test() {
        long expected = 661;
        assertEquals(expected, Problem66.solution3());
    }

    @Test
    public void Problem67Test() {
        long expected = 7273;
        assertEquals(expected, Problem67.solution1());
    }

    @Test
    public void Problem68Test() {
        long expected = 6531031914842725L;
        assertEquals(expected, Problem68.solution1());
    }

    @Test
    public void Problem69Test() {
        long expected = 510510;
        assertEquals(expected, Problem69.solution1());
    }

    @Test
    public void Problem70Test() {
        long expected = 8319823;
        assertEquals(expected, Problem70.solution1());
    }

    @Test
    public void Problem71Test() {
        long expected = 428570;
        assertEquals(expected, Problem71.solution1());
    }

    @Test
    public void Problem72Test() {
        long expected = 303963552391L;
        assertEquals(expected, Problem72.solution2());
    }

    @Test
    public void Problem73Test() {
        long expected = 7295372;
        assertEquals(expected, Problem73.solution1());
    }

    @Test
    public void Problem74Test() {
        long expected = 402;
        assertEquals(expected, Problem74.solution1());
    }

    @Test
    public void Problem75Test() {
        long expected = 161667;
        assertEquals(expected, Problem75.solution1());
    }

    @Test
    public void Problem76Test() {
        long expected = 190569291;
        assertEquals(expected, Problem76.solution1());
    }

    @Test
    public void Problem77Test() {
        long expected = 71;
        assertEquals(expected, Problem77.solution1());
    }

    @Test
    public void Problem78Test() {
        long expected = 55374;
        assertEquals(expected, Problem78.solution1());
    }

    @Test
    public void Problem79Test() {
        long expected = 73162890;
        assertEquals(expected, Problem79.solution1());
    }

    @Test
    public void Problem80Test() {
        long expected = 40886;
        assertEquals(expected, Problem80.solution1());
    }

    @Test
    public void Problem81Test() {
        long expected = 427337;
        assertEquals(expected, Problem81.solution1());
    }

    @Test
    public void Problem82Test() {
        long expected = 260324;
        assertEquals(expected, Problem82.solution1());
    }

    @Test
    public void Problem83Test() {
        long expected = 425185;
        assertEquals(expected, Problem83.solution1());
    }

    @Test
    public void Problem84Test() {
        String expected = "101524";
        assertEquals(expected, Problem84.solution1());
    }

    @Test
    public void Problem85Test() {
        long expected = 2772;
        assertEquals(expected, Problem85.solution1());
    }

    @Test
    public void Problem86Test() {
        long expected = 1818;
        assertEquals(expected, Problem86.solution1());
    }

    @Test
    public void Problem87Test() {
        long expected = 1097343;
        assertEquals(expected, Problem87.solution1());
    }

    @Test
    public void Problem88Test() {
        long expected = 7587457;
        assertEquals(expected, new Problem88().solution1());
    }

    @Test
    public void Problem89Test() {
        long expected = 743;
        assertEquals(expected, Problem89.solution1());
    }

    @Test
    public void Problem90Test() {
        long expected = 1217;
        assertEquals(expected, Problem90.solution1());
    }

    @Test
    public void Problem91Test() {
        long expected = 14234;
        assertEquals(expected, Problem91.solution1());
    }

    @Test
    public void Problem92test() {
        long expected = 8581146;
        assertEquals(expected, Problem92.solution1());
    }

    @Test
    public void Problem93test() {
        String expected = "1258";
        assertEquals(expected, Problem93.solution1());
    }

    @Test
    public void Problem97Test() {
        long expected = 8739992577L;
        assertEquals(expected, Problem97.solution1());
    }

    @Test
    public void Problem99Test() {
        long expected = 709;
        assertEquals(expected, Problem99.solution1());
    }
}
