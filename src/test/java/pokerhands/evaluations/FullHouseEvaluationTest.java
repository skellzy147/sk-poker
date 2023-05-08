package pokerhands.evaluations;

import static helpers.CardConstants.ACE_HEART;
import static helpers.CardConstants.KING_CLUB;
import static helpers.CardConstants.KING_DIAMOND;
import static helpers.CardConstants.KING_HEART;
import static helpers.CardConstants.TWO_CLUB;
import static helpers.CardConstants.TWO_HEART;
import static helpers.CardConstants.TWO_SPADE;

import data.Card;
import data.Rank;
import game.PokerHand;
import junit.framework.TestCase;

public class FullHouseEvaluationTest extends TestCase {

    private FullHouseEvaluation fullHouseEvaluation;

    @Override
    public void setUp() throws Exception {
        fullHouseEvaluation = new FullHouseEvaluation();
    }

    public void testFullHouseHighValue() {
        Card[] cards = new Card[]{
                TWO_HEART, KING_DIAMOND, KING_CLUB, TWO_CLUB, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = fullHouseEvaluation.evaluate(hand);
        assertEquals(fullHouseEvaluation.VALUE * Rank.KING.getValue(), result);
    }

    public void testFullHouseLowValue() {
        Card[] cards = new Card[]{
                TWO_HEART, KING_DIAMOND, TWO_SPADE, TWO_CLUB, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = fullHouseEvaluation.evaluate(hand);
        assertEquals(fullHouseEvaluation.VALUE * Rank.TWO.getValue(), result);
    }

    public void testNotFullHouse() {
        Card[] cards = new Card[]{
                TWO_HEART, KING_DIAMOND, TWO_SPADE, TWO_CLUB, ACE_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = fullHouseEvaluation.evaluate(hand);
        assertEquals(0.0, result);
    }
}