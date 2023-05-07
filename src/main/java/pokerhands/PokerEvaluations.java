package pokerhands;

import game.PokerHand;
import pokerhands.evaluations.AbstractHandEvaluation;
import pokerhands.evaluations.FlushEvaluation;
import pokerhands.evaluations.FourOfAKindEvaluation;
import pokerhands.evaluations.FullHouseEvaluation;
import pokerhands.evaluations.OnePairEvaluation;
import pokerhands.evaluations.RoyalFlushEvaluation;
import pokerhands.evaluations.StraightEvaluation;
import pokerhands.evaluations.StraightFlushEvaluation;
import pokerhands.evaluations.ThreeOfAKindEvaluation;
import pokerhands.evaluations.TwoPairEvaluation;

public class PokerEvaluations {

    private AbstractHandEvaluation[] evaluations;

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

    public double evaluateHand(PokerHand pokerHand) {
        for (AbstractHandEvaluation evaluation : evaluations) {
            double value = evaluation.evaluate(pokerHand);
            if (value != 0) {
                return value;
            }
        }
        return pokerHand.getCards()[0].getRank().getValue();
    }
}
