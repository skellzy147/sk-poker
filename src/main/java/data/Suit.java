package data;

public enum Suit {

    // HEARTS
    H("♥"),
    // DIAMONDS
    D("◆"),
    // CLUBS
    C("♣"),
    // SPADES
    S("♠");

    private String name;

    Suit(String name) {
        this.name = name;
    }

    public boolean matchesColour(Suit other) {
        if (this.equals(H) || this.equals(D)) {
            return other.equals(H) || other.equals(D);
        }

        return other.equals(C) || other.equals(S);
    }

    @Override
    public String toString() {
        return name;
    }
}
