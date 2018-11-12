package design_pattern.strategy;

/**
 * Created by bsankar on 5/21/2014.
 */
public class FlyNoWay implements IFlyBehavior {
    public void fly() {
        System.out.println("I can't fly");
    }
}
