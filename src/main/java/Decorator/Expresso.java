package Decorator;

/**
 * Created by bsankar on 6/12/2014.
 */
public class Expresso implements Beverage {

    @Override
    public String getDescription() {
        return "Expresso";
    }

    @Override
    public double getCost() {
        return 1.99;
    }
}
