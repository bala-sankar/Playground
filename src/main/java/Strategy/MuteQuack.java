package Strategy;

/**
 * Created by bsankar on 5/21/2014.
 */
public class MuteQuack implements IQuackBehavior {
    public void quack() {
        System.out.println("Mute");
    }
}
