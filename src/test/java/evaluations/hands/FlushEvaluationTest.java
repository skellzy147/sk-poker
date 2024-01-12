package evaluations.hands;

import static helpers.CardConstants.EIGHT_HEART;
import static helpers.CardConstants.FOUR_HEART;
import static helpers.CardConstants.KING_DIAMOND;
import static helpers.CardConstants.KING_HEART;
import static helpers.CardConstants.SIX_HEART;
import static helpers.CardConstants.TEN_HEART;

import data.Card;
import game.PokerHand;
import junit.framework.TestCase;

public class FlushEvaluationTest extends TestCase {

    private FlushEvaluation flushEvaluation;

    @Override
    public void setUp() throws Exception {
        flushEvaluation = new FlushEvaluation();
    }

    public void testAllSameSuitReturnsValue() {
        Card[] cards = new Card[] {
                KING_HEART, TEN_HEART, EIGHT_HEART, SIX_HEART, FOUR_HEART
        };
        PokerHand pokerHand = new PokerHand(cards);
        var result = flushEvaluation.evaluate(pokerHand);
        var expectedValue = KING_HEART.getRank().getValue() * flushEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testNotAllSameSuitReturnsZero() {
        Card[] cards = new Card[] {
                KING_HEART, KING_DIAMOND, EIGHT_HEART, SIX_HEART, FOUR_HEART
        };
        PokerHand pokerHand = new PokerHand(cards);
        var result = flushEvaluation.evaluate(pokerHand);
        assertEquals(0.0, result);
    }
}