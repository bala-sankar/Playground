package designpattern.strategy;

/**
 * Created by bsankar on 5/21/2014.
 */
public class Squeak implements IQuackBehavior {
    public void quack() {
        System.out.println("Squeak");
    }
}
