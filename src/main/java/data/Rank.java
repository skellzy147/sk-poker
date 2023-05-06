package data;

public enum Rank {
    ACE("A", 2.2),
    KING("K", 2.1),
    QUEEN("Q", 2),
    JACK("J", 1.9),
    TEN("10", 1.8),
    NINE("9", 1.7),
    EIGHT("8", 1.6),
    SEVEN("7", 1.5),
    SIX("6", 1.4),
    FIVE("5", 1.3),
    FOUR("4", 1.2),
    THREE("3", 1.1),
    TWO("2", 1);

    String name;
    double value;

    Rank(String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name;
    }

    public double getValue() {
        return value;
    }
}
