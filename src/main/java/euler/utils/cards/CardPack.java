package euler.utils.cards;

import java.util.TreeMap;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/1/12
 */
public class CardPack {
    private TreeMap<String, Card> pack;

    public CardPack() {
        if (pack == null) {
            pack = new TreeMap<String, Card>();
            for (CardSuit suit : CardSuit.values()) {
                for (CardValue value : CardValue.values()) {
                    pack.put(String.valueOf(value.getSymbol()) + String.valueOf(suit.getSymbol()),
                            new Card(value, suit));
                }
            }
        }
    }

    public TreeMap<String, Card> getMap() {
        return pack;
    }

    public static class Card {
        private CardValue value;
        private CardSuit suit;

        private Card(CardValue value, CardSuit suit) {
            this.value = value;
            this.suit = suit;
        }

        public CardValue getCardValue() {
            return this.value;
        }

        public CardSuit getCardSuit() {
            return this.suit;
        }
    }
}
