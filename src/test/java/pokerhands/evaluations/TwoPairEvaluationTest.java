package pokerhands.evaluations;

import static helpers.CardConstants.FOUR_DIAMOND;
import static helpers.CardConstants.KING_CLUB;
import static helpers.CardConstants.KING_HEART;
import static helpers.CardConstants.KING_SPADE;
import static helpers.CardConstants.THREE_CLUB;
import static helpers.CardConstants.THREE_HEART;
import static helpers.CardConstants.TWO_HEART;
import static helpers.CardConstants.TWO_SPADE;

import data.Card;
import game.PokerHand;
import junit.framework.TestCase;

public class TwoPairEvaluationTest extends TestCase {

    private TwoPairEvaluation twoPairEvaluation;

    @Override
    public void setUp() throws Exception {
        twoPairEvaluation = new TwoPairEvaluation();
    }

    public void testTwoPairEvaluationHigh() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, TWO_SPADE, KING_SPADE, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        System.out.println(hand.debugCounts());
        var result = twoPairEvaluation.evaluate(hand);
        var expectedValue = KING_HEART.getRank().getValue() * twoPairEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testTwoPairEvaluationLow() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, TWO_SPADE, KING_SPADE, THREE_CLUB
        };
        PokerHand hand = new PokerHand(cards);
        var result = twoPairEvaluation.evaluate(hand);
        var expectedValue = THREE_HEART.getRank().getValue() * twoPairEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testNotTwoPair() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, TWO_SPADE, KING_SPADE, FOUR_DIAMOND
        };
        PokerHand hand = new PokerHand(cards);
        var result = twoPairEvaluation.evaluate(hand);
        assertEquals(0.0, result);
    }
}