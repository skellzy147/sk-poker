package evaluations.hands;

import data.Rank;
import data.Suit;
import game.PokerHand;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

// In order, not same suit
public class StraightEvaluation extends AbstractHandEvaluation {

    final double VALUE = 36;

    public StraightEvaluation() {
        super("Straight");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        if (check(pokerHand.getRankMap(), pokerHand.getSuitMap())) {
            return VALUE * pokerHand.getCards()[0].getRank().getValue();
        }
        return 0;
    }

    private boolean check(Map<Rank, Integer> cards, Map<Suit, Integer> suitMap) {
        if (cards.keySet().size() == 5 && suitMap.keySet().size() > 1) {
            Rank[] ranks = cards.keySet().toArray(new Rank[0]);
            for (int i = 0; i < 4; i++) {
                BigDecimal valueDiff = BigDecimal.valueOf(ranks[i].getValue() - ranks[i+1].getValue());
                valueDiff = valueDiff.setScale(2, RoundingMode.HALF_UP);
                if(valueDiff.doubleValue() != 0.1) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
