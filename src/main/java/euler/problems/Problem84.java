package euler.problems;

import euler.utils.monopoly.MonopolyGame;
import euler.utils.monopoly.TwoFourSidedDice;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 8/20/12
 */
public class Problem84 {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.println("Result is : " + solution1());
        System.out.println("Time = " + (System.currentTimeMillis() - startTime) / 1000.0);
    }

    public static String solution1() {
        String modalString = "";
        MonopolyGame game = new MonopolyGame();
        try {
            game.startGame(new TwoFourSidedDice(), 5000000);
            //game.startGame(new TwoSixSidedDice(), 5000000);
            modalString = game.getModalString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return modalString;
    }
}
