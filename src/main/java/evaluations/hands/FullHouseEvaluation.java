package evaluations.hands;

import data.Rank;
import game.PokerHand;

import java.util.Map;
import java.util.Objects;

// One Pair, One Three of a kind
public class FullHouseEvaluation extends AbstractHandEvaluation {
    final double VALUE = 177;

    public FullHouseEvaluation() {
        super("Full House");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        var rankMap = pokerHand.getRankMap();
        double rankValue = check(rankMap);
        return rankValue > 0 ? rankValue * VALUE : rankValue;
    }

    private double check(Map<Rank, Integer> map) {
        if (map.containsValue(3) && map.containsValue(2)) {
            return map.entrySet()
                      .stream()
                      .filter(entry -> Objects.equals(entry.getValue(), 3))
                      .map(rankIntegerEntry -> rankIntegerEntry.getKey().getValue())
                      .findFirst().orElse(0.0);
        }
        return 0.0;
    }
}
