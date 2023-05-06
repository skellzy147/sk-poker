package pokerhands;

import data.Card;
import game.Hand;

public class PokerEvaluations {

    private AbstractHandEvaluation[] evaluations;

    public PokerEvaluations() {
        AbstractHandEvaluation[] evaluations = {
                new RoyalFlushEvaluation()
        };
        this.evaluations = evaluations;
    }

    public double evaluateHand(Hand hand) {
        for (AbstractHandEvaluation evaluation : evaluations) {
            double value = evaluation.evaluate(hand);
            if (value != 0) {
                return value;
            }
        }
        return hand.getCards()[0].getRank().getValue();
    }
}
