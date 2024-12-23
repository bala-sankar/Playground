import designpattern.decorator.*;
import designpattern.observer.CurrentConditionsDisplay;
import designpattern.observer.WeatherData;
import designpattern.singleton.Singleton;
import designpattern.strategy.Duck;
import designpattern.strategy.MallardDuck;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 9/17/13
 */
@Timeout(value = 30, unit = TimeUnit.SECONDS, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
@Execution(value = ExecutionMode.CONCURRENT)
public class DesignPatternTest {
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
        System.out.println("Time took to run all the tests in DesignPatternTest:\t" + elapsedTime);
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
    public void SingletonTest() {
        Singleton instance = Singleton.getInstance();
        assertEquals(instance, Singleton.getInstance());
    }

    @Test
    public void StrategyTest() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }

    @Test
    public void ObserverTest() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(10.1f, 20.2f, 30.3f);
        assertEquals("Current conditions: 10.1F degrees and 20.2%humidity", currentConditionsDisplay.display());
    }

    @Test
    public void DecoratorTest() {
        Beverage expresso = new Expresso();
        assertEquals("Expresso", expresso.getDescription());
        assertEquals(1.99, expresso.getCost(), 0.01);

        Beverage houseBlendBeverage = new HouseBlend();
        houseBlendBeverage = new Mocha(houseBlendBeverage);
        houseBlendBeverage = new Mocha(houseBlendBeverage);
        houseBlendBeverage = new Whip(houseBlendBeverage);
        assertEquals("House Blend, Mocha, Mocha, Whip", houseBlendBeverage.getDescription());
        assertEquals(1.39, houseBlendBeverage.getCost(), 0.01);

    }
}
