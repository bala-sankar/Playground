package euler.utils.monopoly;

import java.util.Random;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 9/11/12
 */
public class Dice {
    private int size;
    private Random random = new Random();

    public Dice(int size) {
        this.size = size;
    }

    public int roll() {
        return (random.nextInt(size)) + 1;
    }
}
