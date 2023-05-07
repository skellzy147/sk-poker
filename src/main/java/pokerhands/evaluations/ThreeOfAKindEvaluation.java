package pokerhands.evaluations;

import data.Card;
import game.PokerHand;
import pokerhands.evaluations.AbstractHandEvaluation;

//3 of same rank
//TODO
public class ThreeOfAKindEvaluation implements AbstractHandEvaluation {

    final double VALUE = 16;

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
