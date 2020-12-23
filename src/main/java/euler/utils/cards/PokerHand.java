package euler.utils.cards;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: bsankar
 * Date: 3/2/12
 */
public class PokerHand {
    private HashMap<PokerHandRank, CardValue> pokerHand = new HashMap<PokerHandRank, CardValue>();

    public PokerHand(ArrayList<CardPack.Card> cards) {
        //PokerHand hand should be equal to Five
        if (cards.size() != 5) {
            return;
        }
        //To get pairs/kind
        HashMap<CardValue, Integer> kindCount = new HashMap<CardValue, Integer>();
        HashSet<CardValue> values = new HashSet<CardValue>();
        HashSet<CardSuit> suits = new HashSet<CardSuit>();

        //Scan the cards and extract info
        for (CardPack.Card card : cards) {
            CardValue cardVal = card.getCardValue();
            suits.add(card.getCardSuit());
            values.add(cardVal);
            if (kindCount.containsKey(cardVal)) {
                kindCount.put(cardVal, kindCount.get(cardVal) + 1);
            } else {
                kindCount.put(cardVal, 1);
            }
        }


        TreeSet<Integer> sortedCardValues = new TreeSet<Integer>();
        for (CardValue cardValue : values) {
            sortedCardValues.add(cardValue.getValue());
        }

        // Check for ROYAL_FLUSH, STRAIGHT_FLUSH and STRAIGHT
        boolean isSequentialValues = CardValue.isSequentialCardValues(values);
        if (isSequentialValues) {
            if (suits.size() == 1) {
                if (CardValue.TEN == CardValue.getCardValueByValue(sortedCardValues.first())) {
                    pokerHand.put(PokerHandRank.ROYAL_FLUSH, CardValue.TEN);
                    return;
                } else {
                    pokerHand.put(PokerHandRank.STRAIGHT_FLUSH,
                            CardValue.getCardValueByValue(sortedCardValues.first()));
                    return;
                }
            } else {
                pokerHand.put(PokerHandRank.STRAIGHT,
                        CardValue.getCardValueByValue(sortedCardValues.first()));
                return;
            }
        }
        //Check for flush
        if (suits.size() == 1) {
            pokerHand.put(PokerHandRank.FLUSH, CardValue.getCardValueByValue(sortedCardValues.last()));
            sortedCardValues.remove(sortedCardValues.last());
            return;
        }
        //Check for Four_Kind
        for (Map.Entry<CardValue, Integer> entry : kindCount.entrySet()) {
            int count = entry.getValue();
            CardValue cardValue = entry.getKey();
            //Four Kind
            if (count == 4) {
                pokerHand.put(PokerHandRank.FOUR_KIND, cardValue);
            } else if (count == 3) {
                //Full house
                if (pokerHand.containsKey(PokerHandRank.ONE_PAIR)) {
                    pokerHand.put(PokerHandRank.FULL_HOUSE, cardValue);
                    pokerHand.remove(PokerHandRank.ONE_PAIR);
                    return;
                }
                //Three_kind
                else {
                    pokerHand.put(PokerHandRank.THREE_KIND, cardValue);
                }
            } else if (count == 2) {
                //Two Pair
                if (pokerHand.containsKey(PokerHandRank.ONE_PAIR)) {
                    int tempVal = (pokerHand.get(PokerHandRank.ONE_PAIR).getValue() > cardValue.getValue()) ?
                            pokerHand.get(PokerHandRank.ONE_PAIR).getValue() : cardValue.getValue();
                    pokerHand.put(PokerHandRank.TWO_PAIR, CardValue.getCardValueByValue(tempVal));
                    pokerHand.remove(PokerHandRank.ONE_PAIR);
                }
                //Full house
                else if (pokerHand.containsKey(PokerHandRank.THREE_KIND)) {
                    pokerHand.put(PokerHandRank.FULL_HOUSE,
                            pokerHand.get(PokerHandRank.THREE_KIND));
                    pokerHand.remove(PokerHandRank.THREE_KIND);
                    return;
                } else {
                    //Pair
                    pokerHand.put(PokerHandRank.ONE_PAIR, cardValue);
                }
            }
            if (count > 1) {
                sortedCardValues.remove(Integer.valueOf(cardValue.getValue()));
            }
        }

        int rank = 5;
        for (int val : sortedCardValues.descendingSet()) {
            pokerHand.put(PokerHandRank.getByRank(rank),
                    CardValue.getCardValueByValue(val));
            rank--;
        }
    }

    public boolean isWinner(PokerHand player2) {
        PokerHand player1 = this;

        TreeSet<Integer> player1Ranks = new TreeSet<Integer>();
        for (PokerHandRank hand : player1.pokerHand.keySet()) {
            player1Ranks.add(hand.rank);
        }

        TreeSet<Integer> player2Ranks = new TreeSet<Integer>();
        for (PokerHandRank hand : player2.pokerHand.keySet()) {
            player2Ranks.add(hand.rank);
        }
        for (int p1 : player1Ranks.descendingSet()) {
            int p2 = player2Ranks.size() == 0 ? 0 : player2Ranks.last();
            if (p1 > p2) {
                return true;
            } else if (p1 < p2) {
                return false;
            } else {
                int val1 = player1.pokerHand.get(PokerHandRank.getByRank(p1)).getValue();
                int val2 = player2.pokerHand.get(PokerHandRank.getByRank(p2)).getValue();
                if (val1 > val2) {
                    return true;
                } else if (val1 < val2) {
                    return false;
                } else {
                    player2Ranks.remove(Integer.valueOf(p2));
                }
            }
        }
        return false;
    }

    public String toString() {
        TreeSet<Integer> ranks = new TreeSet<Integer>();
        for (PokerHandRank hand : pokerHand.keySet()) {
            ranks.add(hand.rank);
        }

        StringBuilder line = new StringBuilder();
        for (int rank : ranks.descendingSet()) {
            line.append(PokerHandRank.getByRank(rank).name());
            line.append("\t");
            line.append(pokerHand.get(PokerHandRank.getByRank(rank)).name());
            line.append("\n");
        }
        return line.toString();
    }

    public enum PokerHandRank {
        FIFTH_HIGHEST(1),
        FOURTH_HIGHEST(2),
        THIRD_HIGHEST(3),
        SECOND_HIGHEST(4),
        HIGHEST_CARD(5),
        ONE_PAIR(6),
        TWO_PAIR(7),
        THREE_KIND(8),
        STRAIGHT(9),
        FLUSH(10),
        FULL_HOUSE(11),
        FOUR_KIND(12),
        STRAIGHT_FLUSH(13),
        ROYAL_FLUSH(14);

        private final int rank;

        private PokerHandRank(int rank) {
            this.rank = rank;
        }

        public static PokerHandRank getByRank(int rank) {
            switch (rank) {
                case 1:
                    return FIFTH_HIGHEST;
                case 2:
                    return FOURTH_HIGHEST;
                case 3:
                    return THIRD_HIGHEST;
                case 4:
                    return SECOND_HIGHEST;
                case 5:
                    return HIGHEST_CARD;
                case 6:
                    return ONE_PAIR;
                case 7:
                    return TWO_PAIR;
                case 8:
                    return THREE_KIND;
                case 9:
                    return STRAIGHT;
                case 10:
                    return FLUSH;
                case 11:
                    return FULL_HOUSE;
                case 12:
                    return FOUR_KIND;
                case 13:
                    return STRAIGHT_FLUSH;
                case 14:
                    return ROYAL_FLUSH;
            }
            return null;
        }
    }
}


