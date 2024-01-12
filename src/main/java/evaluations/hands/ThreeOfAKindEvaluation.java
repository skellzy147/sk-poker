package evaluations.hands;

import data.Rank;
import game.PokerHand;

import java.util.Map;
import java.util.Objects;

//3 of same rank
public class ThreeOfAKindEvaluation extends AbstractHandEvaluation {

    final double VALUE = 16;

    public ThreeOfAKindEvaluation() {
        super("Three Of A Kind");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        var rankMap = pokerHand.getRankMap();
        double rankValue = check(rankMap);
        return rankValue > 0 ? rankValue * VALUE : rankValue;
    }

    private double check(Map<Rank, Integer> rankIntegerMap) {
        if (rankIntegerMap.containsValue(3) && !rankIntegerMap.containsValue(2)) {
            return rankIntegerMap.entrySet()
                                 .stream()
                                 .filter(entry -> Objects.equals(entry.getValue(), 3))
                                 .map(rankIntegerEntry -> rankIntegerEntry.getKey().getValue())
                                 .findFirst().orElse(0.0);
        }
        return 0.0;
    }
}
