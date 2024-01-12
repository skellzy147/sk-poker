package evaluations;

import game.PokerHand;
import evaluations.hands.AbstractHandEvaluation;
import evaluations.hands.FlushEvaluation;
import evaluations.hands.FourOfAKindEvaluation;
import evaluations.hands.FullHouseEvaluation;
import evaluations.hands.OnePairEvaluation;
import evaluations.hands.RoyalFlushEvaluation;
import evaluations.hands.StraightEvaluation;
import evaluations.hands.StraightFlushEvaluation;
import evaluations.hands.ThreeOfAKindEvaluation;
import evaluations.hands.TwoPairEvaluation;

public class PokerEvaluations {

    private final AbstractHandEvaluation[] evaluations;

    public PokerEvaluations() {
        this.evaluations = new AbstractHandEvaluation[]{
                new RoyalFlushEvaluation(),
                new StraightFlushEvaluation(),
                new FourOfAKindEvaluation(),
                new FullHouseEvaluation(),
                new FlushEvaluation(),
                new StraightEvaluation(),
                new ThreeOfAKindEvaluation(),
                new TwoPairEvaluation(),
                new OnePairEvaluation()
        };
    }

    public PokerHand.HandEvaluation evaluateHand(PokerHand pokerHand) {
        for (AbstractHandEvaluation evaluation : evaluations) {
            double value = evaluation.evaluate(pokerHand);
            if (value != 0) {
                return new PokerHand.HandEvaluation(value, evaluation.getName());
            }
        }

        return new PokerHand.HandEvaluation(pokerHand.getCards()[0].getRank().getValue(), "High Card");
    }
}
