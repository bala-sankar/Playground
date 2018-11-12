package design_pattern.decorator;

/**
 * Created by bsankar on 6/12/2014.
 */
public class Expresso implements Beverage {
    public String getDescription() {
        return "Expresso";
    }
    public double getCost() {
        return 1.99;
    }
}
