package designpattern.decorator;

/**
 * Created by bsankar on 6/12/2014.
 */
public class Mocha extends CondimentDecorator {
    public Mocha(Beverage beverage) {
        super(beverage);
    }
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
    public double getCost() {
        return 0.20 + beverage.getCost();
    }
}
