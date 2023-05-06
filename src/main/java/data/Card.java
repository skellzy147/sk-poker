package data;

public class Card implements Comparable<Card> {

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public boolean isEqual(Suit suit, Rank rank) {
        return this.suit.equals(suit) && this.rank.equals(rank);
    }

    @Override
    public String toString() {
        return rank.toString() + suit.toString();
    }

    @Override
    public int compareTo(Card o) {
        return this.rank.compareTo(o.rank);
    }
}
