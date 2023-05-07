package pokerhands.evaluations;

import data.Card;
import game.PokerHand;

// One Pair, One Three of a kind
// TODO
public class FullHouseEvaluation implements AbstractHandEvaluation {

    final double VALUE = 177;

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
