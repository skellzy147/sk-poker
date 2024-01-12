package game;

import data.Card;
import evaluations.PokerEvaluations;

public class PokerHandFactory {

    private PokerEvaluations pokerEvaluations;

    public PokerHandFactory() {
        this.pokerEvaluations = new PokerEvaluations();
    }

    public PokerHand dealPokerHand(Card[] cards) {
        PokerHand playerPokerHand = new PokerHand(cards);
        PokerHand.HandEvaluation evaluation = pokerEvaluations.evaluateHand(playerPokerHand);
        playerPokerHand.setHandEvaluation(evaluation);
        return playerPokerHand;
    }
}
