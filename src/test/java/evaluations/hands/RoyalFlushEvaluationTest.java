package evaluations.hands;

import static helpers.CardConstants.ACE_HEART;
import static helpers.CardConstants.ACE_SPADE;
import static helpers.CardConstants.FOUR_HEART;
import static helpers.CardConstants.JACK_HEART;
import static helpers.CardConstants.KING_HEART;
import static helpers.CardConstants.QUEEN_HEART;
import static helpers.CardConstants.TEN_HEART;

import data.Card;
import game.PokerHand;
import junit.framework.TestCase;


public class RoyalFlushEvaluationTest extends TestCase {

    private RoyalFlushEvaluation royalFlushEvaluation;

    @Override
    public void setUp() throws Exception {
        royalFlushEvaluation = new RoyalFlushEvaluation();
    }

    public void testSameSuitRoyalFlush() {
        Card[] cards = new Card[] {
                ACE_HEART,
                KING_HEART,
                QUEEN_HEART,
                JACK_HEART,
                TEN_HEART
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = royalFlushEvaluation.evaluate(pokerHand);

        assertEquals(royalFlushEvaluation.VALUE, value);
    }

    public void testDifferentSuitRoyalFlush() {
        Card[] cards = new Card[] {
                ACE_SPADE,
                KING_HEART,
                QUEEN_HEART,
                JACK_HEART,
                TEN_HEART
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = royalFlushEvaluation.evaluate(pokerHand);

        assertEquals(0.0, value);
    }

    public void testSameSuitNotFlush() {
        Card[] cards = new Card[] {
                ACE_HEART,
                KING_HEART,
                QUEEN_HEART,
                JACK_HEART,
                FOUR_HEART
        };

        PokerHand pokerHand = new PokerHand(cards);

        double value = royalFlushEvaluation.evaluate(pokerHand);


        assertEquals(0.0, value);
    }
}