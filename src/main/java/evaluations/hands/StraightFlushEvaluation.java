package evaluations.hands;

import data.Rank;
import data.Suit;
import game.PokerHand;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

// In order, not king, queen, jack etc, all same suit
public class StraightFlushEvaluation extends AbstractHandEvaluation {

    final double VALUE = 859;

    public StraightFlushEvaluation() {
        super("Straight Flush");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        if (check(pokerHand)) {
            return VALUE * pokerHand.getCards()[0].getRank().getValue();
        }
        return 0;
    }

    private boolean check(PokerHand pokerHand) {
        // straight flush does not begin with ACE
        if (pokerHand.getCards()[0].getRank() == Rank.ACE) {
            return false;
        }
        Map<Suit, Integer> suitMap = pokerHand.getSuitMap();
        Map<Rank, Integer> rankMap = pokerHand.getRankMap();
        if (suitMap.keySet().size() == 1 && rankMap.keySet().size() == 5) {
            Rank[] ranks = rankMap.keySet().toArray(new Rank[0]);
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
