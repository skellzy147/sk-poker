package pokerhands.evaluations;

import data.Card;
import game.PokerHand;
import junit.framework.TestCase;

import static helpers.CardConstants.*;

public class OnePairEvaluationTest extends TestCase {

    private OnePairEvaluation onePairEvaluation;

    @Override
    public void setUp() throws Exception {
        onePairEvaluation = new OnePairEvaluation();
    }

    public void testTwoPairEvaluationHigh() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, KING_DIAMOND, QUEEN_SPADE, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        System.out.println(hand.debugCounts());
        var result = onePairEvaluation.evaluate(hand);
        var expectedValue = KING_DIAMOND.getRank().getValue() * onePairEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testTwoPairEvaluationLow() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, TWO_SPADE, KING_SPADE, QUEEN_SPADE
        };
        PokerHand hand = new PokerHand(cards);
        var result = onePairEvaluation.evaluate(hand);
        var expectedValue = TWO_HEART.getRank().getValue() * onePairEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testNotTwoPair() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, FIVE_HEART, KING_SPADE, FOUR_DIAMOND
        };
        PokerHand hand = new PokerHand(cards);
        var result = onePairEvaluation.evaluate(hand);
        assertEquals(0.0, result);
    }

}