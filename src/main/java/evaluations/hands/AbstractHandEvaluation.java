package evaluations.hands;

import game.PokerHand;

public abstract class AbstractHandEvaluation {

    private String name;

    public AbstractHandEvaluation(String name) {
        this.name = name;
    }

    public abstract double evaluate(PokerHand cards);

    public String getName() {
        return this.name;
    }


}
