package pokerhands.evaluations;

import data.Rank;
import game.PokerHand;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

// Two Pairs
public class TwoPairEvaluation extends AbstractHandEvaluation {

    final double VALUE = 7;

    public TwoPairEvaluation() {
        super("Two Pairs");
    }

    @Override
    public double evaluate(PokerHand pokerHand) {
        var rankMap = pokerHand.getRankMap();
        double rankValue = check(rankMap);
        return rankValue > 0 ? rankValue * VALUE : rankValue;
    }

    private double check(Map<Rank, Integer> pokerHand) {
        int occurrences = Collections.frequency(pokerHand.values(), 2);
        if (occurrences == 2) {
            return pokerHand.entrySet()
                            .stream()
                            .filter(entry -> Objects.equals(entry.getValue(), 2))
                            .map(rankIntegerEntry -> rankIntegerEntry.getKey().getValue())
                            .findFirst().orElse(0.0);
        }
        return 0.0;
    }
}
