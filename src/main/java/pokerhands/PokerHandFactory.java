package pokerhands;

import data.Card;
import game.PokerHand;

public class PokerHandFactory {

    private PokerEvaluations pokerEvaluations;

    public PokerHandFactory() {
        this.pokerEvaluations = new PokerEvaluations();
    }

    public PokerHand dealPokerHand(Card[] cards) {
        PokerHand playerPokerHand = new PokerHand(cards);
        HandEvaluation evaluation = pokerEvaluations.evaluateHand(playerPokerHand);
        playerPokerHand.setHandEvaluation(evaluation);
        return playerPokerHand;
    }
}
