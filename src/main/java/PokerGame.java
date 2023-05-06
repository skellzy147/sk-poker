import data.Card;
import data.Rank;
import data.Suit;

import java.util.ArrayList;
import java.util.Random;

public class PokerGame {
    private ArrayList<Card> deck;

    public PokerGame() {
        this.deck = initDeck();
    }

    private ArrayList<Card> initDeck() {
        ArrayList<Card> deck = new ArrayList<Card>();
        for (Suit suit :Suit.class.getEnumConstants()) {
            for (Rank rank : Rank.class.getEnumConstants()) {
                deck.add(new Card(rank, suit));
            }
        }
        return deck;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Card card : this.deck) {
            builder.append(card.toString()).append(" ");
        }
        return builder.toString();
    }
    
    public Card[] dealCards(int number) {
        Card[] cards = new Card[number];
        Random random = new Random();
        for (int i = 0; i < number; i++) {
            int upperBound = this.deck.size() - 1;
            int index = random.nextInt(upperBound);
            cards[i] = deck.remove(index);;
        }
        return cards;
    }
}
