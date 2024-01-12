package evaluations.hands;

import data.Rank;
import game.PokerHand;

import java.util.Map;
import java.util.Objects;

// Four of same RANK
public class FourOfAKindEvaluation extends AbstractHandEvaluation {

    final double VALUE = 390;

    public FourOfAKindEvaluation() {
        super("Four Of A Kind");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        var rankMap = pokerHand.getRankMap();
        double rankValue = check(rankMap);
        return rankValue > 0 ? rankValue * VALUE : rankValue;
    }

    private double check(Map<Rank, Integer> rankIntegerMap) {
        return rankIntegerMap.entrySet()
                             .stream()
                             .filter(entry -> Objects.equals(entry.getValue(), 4))
                             .map(rankIntegerEntry -> rankIntegerEntry.getKey().getValue())
                             .findFirst().orElse(0.0);
    }
}
