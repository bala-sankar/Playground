package design_pattern.decorator;

/**
 * Created by bsankar on 6/12/2014.
 */
public class Whip extends CondimentDecorator {
    public Whip(Beverage beverage) {
        super(beverage);
    }
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
    public double getCost() {
        return beverage.getCost() + 0.10;
    }
}
