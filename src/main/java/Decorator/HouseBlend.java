package Decorator;

/**
 * Created by bsankar on 6/12/2014.
 */
public class HouseBlend implements Beverage {
    public String getDescription() {
        return "House Blend";
    }
    public double getCost() {
        return 0.89;
    }
}
