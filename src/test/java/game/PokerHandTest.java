package game;

import data.Card;
import data.Rank;
import data.Suit;
import junit.framework.TestCase;

public class PokerHandTest extends TestCase {

    private final Card ACE_HEART = new Card(Rank.ACE, Suit.H);
    private final Card KING_CLUB = new Card(Rank.KING, Suit.C);
    private final Card KING_DIAMOND = new Card(Rank.KING, Suit.D);
    private final Card QUEEN_HEART = new Card(Rank.QUEEN, Suit.H);
    private final Card JACK_HEART = new Card(Rank.JACK, Suit.H);
    private final Card TEN_HEART = new Card(Rank.TEN, Suit.H);
    private final Card ACE_SPADE = new Card(Rank.ACE, Suit.S);
    private final Card FOUR_HEART = new Card(Rank.FOUR, Suit.H);

    public void testRankMapWith5DifferentRanks() {
        Card[] cards = new Card[]{
                ACE_HEART,
                QUEEN_HEART,
                JACK_HEART,
                TEN_HEART,
                FOUR_HEART
        };

        PokerHand hand = new PokerHand(cards);
        var result = hand.getRankMap();
        assertTrue(result.containsKey(Rank.ACE));
        assertEquals(1, (int) result.get(Rank.ACE));
        assertTrue(result.containsKey(Rank.QUEEN));
        assertEquals(1, (int) result.get(Rank.QUEEN));
        assertTrue(result.containsKey(Rank.JACK));
        assertEquals(1, (int) result.get(Rank.JACK));
        assertTrue(result.containsKey(Rank.TEN));
        assertEquals(1, (int) result.get(Rank.TEN));
        assertTrue(result.containsKey(Rank.FOUR));
        assertEquals(1, (int) result.get(Rank.FOUR));

    }

    public void testRankMapWithMultipleSameRanks() {
        Card[] cards = new Card[]{
                ACE_HEART,
                ACE_SPADE,
                JACK_HEART,
                TEN_HEART,
                FOUR_HEART
        };

        PokerHand hand = new PokerHand(cards);
        var result = hand.getRankMap();
        assertTrue(result.containsKey(Rank.ACE));
        assertEquals(2, (int) result.get(Rank.ACE));
        assertTrue(result.containsKey(Rank.JACK));
        assertEquals(1, (int) result.get(Rank.JACK));
        assertTrue(result.containsKey(Rank.TEN));
        assertEquals(1, (int) result.get(Rank.TEN));
        assertTrue(result.containsKey(Rank.FOUR));
        assertEquals(1, (int) result.get(Rank.FOUR));
    }

    public void testSuitMapWithAll4Suits() {
            Card[] cards = new Card[]{
                    ACE_HEART,
                    ACE_SPADE,
                    KING_CLUB,
                    KING_DIAMOND,
                    FOUR_HEART
            };

            PokerHand hand = new PokerHand(cards);
            var result = hand.getSuitMap();
            assertTrue(result.containsKey(Suit.H));
            assertEquals(2, (int) result.get(Suit.H));
            assertTrue(result.containsKey(Suit.S));
            assertEquals(1, (int) result.get(Suit.S));
            assertTrue(result.containsKey(Suit.D));
            assertEquals(1, (int) result.get(Suit.D));
            assertTrue(result.containsKey(Suit.C));
            assertEquals(1, (int) result.get(Suit.C));

    }

    public void testSuitMapWithAllSameSuit() {

            Card[] cards = new Card[]{
                    ACE_HEART,
                    QUEEN_HEART,
                    JACK_HEART,
                    TEN_HEART,
                    FOUR_HEART
            };

            PokerHand hand = new PokerHand(cards);
            var result = hand.getSuitMap();
            assertTrue(result.containsKey(Suit.H));
            assertEquals(5, (int) result.get(Suit.H));

    }
}