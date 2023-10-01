package pokerhands.evaluations;

import game.PokerHand;

// All same suit
public class FlushEvaluation extends AbstractHandEvaluation {

    final double VALUE = 80;

    public FlushEvaluation() {
        super("Flush");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        var cards = pokerHand.getCards();
        if (check(pokerHand)) {
            return VALUE * cards[0].getRank().getValue();
        }
        return 0;
    }

    private boolean check(PokerHand pokerHand) {
        var suitMap = pokerHand.getSuitMap();
        return suitMap.containsValue(5);
    }
}
