package pokerhands.evaluations;

import static helpers.CardConstants.EIGHT_HEART;
import static helpers.CardConstants.FIVE_DIAMOND;
import static helpers.CardConstants.FOUR_HEART;
import static helpers.CardConstants.NINE_CLUB;
import static helpers.CardConstants.SEVEN_HEART;
import static helpers.CardConstants.SIX_CLUB;
import static helpers.CardConstants.TEN_HEART;
import static helpers.CardConstants.THREE_DIAMOND;
import static helpers.CardConstants.THREE_HEART;
import static helpers.CardConstants.TWO_SPADE;

import data.Card;
import data.Rank;
import game.PokerHand;
import junit.framework.TestCase;

public class StraightEvaluationTest extends TestCase {

    private StraightEvaluation straightEvaluation;

    @Override
    public void setUp() throws Exception {
        straightEvaluation = new StraightEvaluation();
    }

    public void testStraightHigh() {
        Card[] cards = new Card[]{
                TEN_HEART,
                NINE_CLUB,
                EIGHT_HEART,
                SEVEN_HEART,
                SIX_CLUB
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = straightEvaluation.evaluate(pokerHand);
        double expectedValue = Rank.TEN.getValue() * straightEvaluation.VALUE;
        assertEquals(expectedValue, value);
    }

    public void testStraightLower() {
        Card[] cards = new Card[]{
                SIX_CLUB,
                FIVE_DIAMOND,
                FOUR_HEART,
                THREE_HEART,
                TWO_SPADE
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = straightEvaluation.evaluate(pokerHand);
        double expectedValue = Rank.SIX.getValue() * straightEvaluation.VALUE;
        assertEquals(expectedValue, value);
    }

    public void testNotStraight() {
        Card[] cards = new Card[]{
                SIX_CLUB,
                FIVE_DIAMOND,
                THREE_DIAMOND,
                THREE_HEART,
                TWO_SPADE
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = straightEvaluation.evaluate(pokerHand);
        assertEquals(0.0, value);
    }
}