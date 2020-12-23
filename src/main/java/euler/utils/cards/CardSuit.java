package euler.utils.cards;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/1/12
 */
public enum CardSuit {
    SPADE('S'),
    CLUB('C'),
    DIAMOND('D'),
    HEART('H');

    private final char symbol;

    private CardSuit(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }

}
