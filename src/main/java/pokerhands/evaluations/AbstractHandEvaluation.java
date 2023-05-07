package pokerhands.evaluations;

import game.PokerHand;

public interface AbstractHandEvaluation {

    double evaluate(PokerHand cards);

}
