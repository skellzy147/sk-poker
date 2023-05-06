package game;

import data.Card;

import java.util.Arrays;

public class Hand {

    Card[] cards;

    public Hand(Card[] cards) {
        Arrays.sort(cards);
        this.cards = cards;
    }

    public Card[] getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Card card: this.cards) {
            builder.append(card.toString()).append(" ");
        }
        return builder.toString();
    }
}
