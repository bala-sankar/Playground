package euler.utils.monopoly;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 9/11/12
 */
public class TwoSixSidedDice implements MonopolyDice {
    private Dice dice1;
    private Dice dice2;
    private int counter = 0;

    public TwoSixSidedDice() {
        this.dice1 = new Dice(6);
        this.dice2 = new Dice(6);
    }

    /*private int roll(int counter){
        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        if(roll1 == roll2){
            if(counter < 3){
                return roll(counter+1);
            } else {
                return  0;
            }
        }
        return roll1+roll2;
    }

    public int roll(){
     return roll(1);
    }*/

    public int roll() {
        int roll1 = dice1.roll();
        int roll2 = dice2.roll();
        if (roll1 == roll2) {
            counter++;
        } else {
            counter = 0;
        }
        if (counter >= 3) {
            counter = 0;
            return 0;
        }
        return roll1 + roll2;
    }


}
