package evaluations.hands;

import static helpers.CardConstants.KING_CLUB;
import static helpers.CardConstants.KING_DIAMOND;
import static helpers.CardConstants.KING_HEART;
import static helpers.CardConstants.KING_SPADE;
import static helpers.CardConstants.TWO_CLUB;
import static helpers.CardConstants.TWO_DIAMOND;
import static helpers.CardConstants.TWO_HEART;
import static helpers.CardConstants.TWO_SPADE;

import data.Card;
import game.PokerHand;
import junit.framework.TestCase;

public class FourOfAKindEvaluationTest extends TestCase {

    private FourOfAKindEvaluation fourOfAKindEvaluation;

    @Override
    public void setUp() throws Exception {
        fourOfAKindEvaluation = new FourOfAKindEvaluation();
    }

    public void testFourOfAKindLowCard() {
        Card[] cards = new Card[]{
                KING_HEART, KING_DIAMOND, KING_CLUB, KING_SPADE, TWO_CLUB
        };
        PokerHand hand = new PokerHand(cards);
        var result = fourOfAKindEvaluation.evaluate(hand);
        var expectedValue = KING_HEART.getRank().getValue() * fourOfAKindEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }


    public void testFourOfAKindHighCard() {
        Card[] cards = new Card[]{
                TWO_HEART, TWO_DIAMOND, TWO_SPADE, TWO_CLUB, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = fourOfAKindEvaluation.evaluate(hand);
        var expectedValue = TWO_HEART.getRank().getValue() * fourOfAKindEvaluation.VALUE;
        assertEquals(expectedValue, result);
    }

    public void testNotFourOfAKind() {
        Card[] cards = new Card[]{
                TWO_HEART, KING_DIAMOND, TWO_SPADE, TWO_CLUB, KING_HEART
        };
        PokerHand hand = new PokerHand(cards);
        var result = fourOfAKindEvaluation.evaluate(hand);
        assertEquals(0.0, result);
    }
}