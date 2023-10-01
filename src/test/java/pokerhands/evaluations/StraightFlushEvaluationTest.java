package pokerhands.evaluations;

import data.Card;
import data.Rank;
import game.PokerHand;
import junit.framework.TestCase;

import static helpers.CardConstants.*;

public class StraightFlushEvaluationTest extends TestCase {

    StraightFlushEvaluation straightFlushEvaluation;

    @Override
    public void setUp() throws Exception {
        straightFlushEvaluation = new StraightFlushEvaluation();
    }

    public void testKingHigh() {
        Card[] cards = new Card[]{
                KING_HEART,
                QUEEN_HEART,
                JACK_HEART,
                TEN_HEART,
                NINE_HEART
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = straightFlushEvaluation.evaluate(pokerHand);
        double expectedValue = Rank.KING.getValue() * straightFlushEvaluation.VALUE;
        assertEquals(expectedValue, value);
    }

    public void testSixHigh() {
        Card[] cards = new Card[]{
                SIX_HEART,
                FIVE_HEART,
                FOUR_HEART,
                THREE_HEART,
                TWO_HEART
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = straightFlushEvaluation.evaluate(pokerHand);
        double expectedValue = Rank.SIX.getValue() * straightFlushEvaluation.VALUE;
        assertEquals(expectedValue, value);
    }

    public void testAceHighReturnsZero() {
        Card[] cards = new Card[]{
                ACE_HEART,
                KING_HEART,
                QUEEN_HEART,
                JACK_HEART,
                TEN_HEART,
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = straightFlushEvaluation.evaluate(pokerHand);
        assertEquals(0.0, value);
    }

    public void testStraightNotSameSuitReturnsZero() {
        Card[] cards = new Card[]{
                SIX_HEART,
                FIVE_DIAMOND,
                FOUR_HEART,
                THREE_HEART,
                TWO_HEART
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = straightFlushEvaluation.evaluate(pokerHand);
        assertEquals(0.0, value);
    }


}