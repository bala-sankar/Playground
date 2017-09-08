package Decorator;

/**
 * Created by bsankar on 6/12/2014.
 */
public abstract class CondimentDecorator implements Beverage {
    protected Beverage beverage;

    protected CondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }
}
