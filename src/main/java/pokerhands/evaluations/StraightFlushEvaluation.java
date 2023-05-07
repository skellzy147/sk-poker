package pokerhands.evaluations;

import data.Card;
import game.PokerHand;
import pokerhands.evaluations.AbstractHandEvaluation;

// In order, not king, queen, jack etc, all same suit
//TODO
public class StraightFlushEvaluation implements AbstractHandEvaluation {

    final double VALUE = 859;

    @Override
    public double evaluate(PokerHand pokerHand) {
        var cards = pokerHand.getCards();
        if (check(cards)) {
            return VALUE * cards[0].getRank().getValue();
        }
        return 0;
    }

    private boolean check(Card[] cards) {
        return false;
    }
}
