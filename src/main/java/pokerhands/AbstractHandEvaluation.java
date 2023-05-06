package pokerhands;

import data.Card;
import game.Hand;

public interface AbstractHandEvaluation {

    double evaluate(Hand cards);

}
