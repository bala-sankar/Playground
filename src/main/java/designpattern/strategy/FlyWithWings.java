package designpattern.strategy;

/**
 * Created by bsankar on 5/21/2014.
 */
public class FlyWithWings implements IFlyBehavior {
    public void fly() {
        System.out.println("I'm flying");
    }
}
