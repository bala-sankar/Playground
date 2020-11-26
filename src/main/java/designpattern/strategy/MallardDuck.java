package designpattern.strategy;

/**
 * Created by bsankar on 5/21/2014.
 */
public class MallardDuck extends Duck {

    public MallardDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();
    }

    public void display() {
        System.out.println("Mallard duck");
    }
}
