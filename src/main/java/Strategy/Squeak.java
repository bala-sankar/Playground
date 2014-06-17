package Strategy;

/**
 * Created by bsankar on 5/21/2014.
 */
public class Squeak implements IQuackBehavior {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
