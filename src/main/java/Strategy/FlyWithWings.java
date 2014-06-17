package Strategy;

/**
 * Created by bsankar on 5/21/2014.
 */
public class FlyWithWings implements IFlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying");
    }
}
