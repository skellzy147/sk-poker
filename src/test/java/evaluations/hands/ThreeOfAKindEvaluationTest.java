package evaluations.hands;

import static helpers.CardConstants.ACE_DIAMOND;
import static helpers.CardConstants.FOUR_CLUB;
import static helpers.CardConstants.KING_CLUB;
import static helpers.CardConstants.KING_DIAMOND;
import static helpers.CardConstants.KING_HEART;
import static helpers.CardConstants.KING_SPADE;
import static helpers.CardConstants.THREE_HEART;
import static helpers.CardConstants.TWO_CLUB;
import static helpers.CardConstants.TWO_DIAMOND;
import static helpers.CardConstants.TWO_HEART;
import static helpers.CardConstants.TWO_SPADE;

import data.Card;
import game.PokerHand;
import junit.framework.TestCase;

public class ThreeOfAKindEvaluationTest extends TestCase {

    private ThreeOfAKindEvaluation threeOfAKindEvaluation;

    @Override
    public void setUp() throws Exception {
        threeOfAKindEvaluation = new ThreeOfAKindEvaluation();
    }

    public void testThreeOfAKindHigh() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, KING_CLUB, KING_SPADE, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = threeOfAKindEvaluation.evaluate(hand);
        var expectedValue = KING_HEART.getRank().getValue() * threeOfAKindEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testThreeOfAKindLow() {
        Card[] cards = new Card[]{
                TWO_HEART, TWO_DIAMOND, TWO_SPADE, ACE_DIAMOND, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = threeOfAKindEvaluation.evaluate(hand);
        var expectedValue = TWO_HEART.getRank().getValue() * threeOfAKindEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testNotThreeOfKindRandom() {
        Card[] cards = new Card[]{
                TWO_HEART, THREE_HEART, FOUR_CLUB, TWO_CLUB, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = threeOfAKindEvaluation.evaluate(hand);
        assertEquals(0.0, result);
    }

    public void testNotThreeOfKindFullHouse() {
        Card[] cards = new Card[]{
                TWO_HEART, TWO_DIAMOND, KING_DIAMOND, KING_CLUB, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = threeOfAKindEvaluation.evaluate(hand);
        assertEquals(0.0, result);
    }
}