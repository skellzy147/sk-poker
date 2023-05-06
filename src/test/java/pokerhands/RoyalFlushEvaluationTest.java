package pokerhands;

import data.Card;
import data.Rank;
import data.Suit;
import game.Hand;
import junit.framework.TestCase;


public class RoyalFlushEvaluationTest extends TestCase {

    private final Card ACE_HEART = new Card(Rank.ACE, Suit.H);
    private final Card KING_HEART = new Card(Rank.KING, Suit.H);
    private final Card QUEEN_HEART = new Card(Rank.QUEEN, Suit.H);
    private final Card JACK_HEART = new Card(Rank.JACK, Suit.H);
    private final Card TEN_HEART = new Card(Rank.TEN, Suit.H);
    private final Card ACE_SPADE = new Card(Rank.ACE, Suit.S);
    private final Card FOUR_HEART = new Card(Rank.FOUR, Suit.H);

    private RoyalFlushEvaluation classUnderTest;

    @Override
    public void setUp() throws Exception {
        classUnderTest = new RoyalFlushEvaluation();
    }

    public void testSameSuitRoyalFlush() {
        Card[] cards = new Card[] {
                ACE_HEART,
                KING_HEART,
                QUEEN_HEART,
                JACK_HEART,
                TEN_HEART
        };

        Hand hand = new Hand(cards);

        double value = classUnderTest.evaluate(hand);


        assertTrue(value > 0);
    }

    public void testDifferentSuitRoyalFlush() {
        Card[] cards = new Card[] {
                ACE_SPADE,
                KING_HEART,
                QUEEN_HEART,
                JACK_HEART,
                TEN_HEART
        };

        Hand hand = new Hand(cards);

        double value = classUnderTest.evaluate(hand);


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

        Hand hand = new Hand(cards);

        double value = classUnderTest.evaluate(hand);


        assertEquals(0.0, value);
    }
}