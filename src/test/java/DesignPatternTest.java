import Decorator.*;
import Observer.CurrentConditionsDisplay;
import Observer.WeatherData;
import Singleton.Singleton;
import Strategy.Duck;
import Strategy.MallardDuck;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 9/17/13
 */
public class DesignPatternTest {
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
        System.out.println("Time took to run all the tests in DesignPatternTest:\t" + elapsedTime);
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
    public void SingletonTest() {
        Singleton instance = Singleton.getInstance();
        Assert.assertTrue(instance.equals(Singleton.getInstance()));
    }

    @Test(timeout = TIMEOUT)
    public void StrategyTest() {
        Duck mallard = new MallardDuck();
        mallard.performQuack();
        mallard.performFly();
    }

    @Test(timeout = TIMEOUT)
    public void ObserverTest() {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(10.1f, 20.2f, 30.3f);
        Assert.assertEquals("Current conditions: 10.1F degrees and 20.2%humidity", currentConditionsDisplay.display());
    }

    @Test(timeout = TIMEOUT)
    public void DecoratorTest() {
        Beverage expresso = new Expresso();
        Assert.assertEquals("Expresso", expresso.getDescription());
        Assert.assertEquals(1.99, expresso.getCost(), 0.01);

        Beverage houseBlendBeverage = new HouseBlend();
        houseBlendBeverage = new Mocha(houseBlendBeverage);
        houseBlendBeverage = new Mocha(houseBlendBeverage);
        houseBlendBeverage = new Whip(houseBlendBeverage);
        Assert.assertEquals("House Blend, Mocha, Mocha, Whip", houseBlendBeverage.getDescription());
        Assert.assertEquals(1.39, houseBlendBeverage.getCost(), 0.01);

    }
}
