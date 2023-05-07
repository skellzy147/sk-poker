package pokerhands.evaluations;

import data.Card;
import game.PokerHand;
import pokerhands.evaluations.AbstractHandEvaluation;

// In order, not same suit
//TODO
public class StraightEvaluation implements AbstractHandEvaluation {

    final double VALUE = 36;

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
