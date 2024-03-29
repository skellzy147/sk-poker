package evaluations.hands;

import data.Card;
import data.Rank;
import data.Suit;
import game.PokerHand;

public class RoyalFlushEvaluation extends AbstractHandEvaluation {

    final double VALUE = 1890;

    public RoyalFlushEvaluation() {
        super("Royal Flush");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        Card[] cards = pokerHand.getCards();
        Card first = cards[0];
        if (first.getRank().equals(Rank.ACE)) {
            Suit desiredSuit = first.getSuit();
            if(checkOtherCards(cards, desiredSuit)) {
                return this.VALUE;
            }
        }
        return 0;
    }

    private boolean checkOtherCards(Card[] cards, Suit desiredSuit) {
        return cards[1].isEqual(desiredSuit, Rank.KING)
                && cards[2].isEqual(desiredSuit, Rank.QUEEN)
                && cards[3].isEqual(desiredSuit, Rank.JACK)
                && cards[4].isEqual(desiredSuit, Rank.TEN);
    }
}
