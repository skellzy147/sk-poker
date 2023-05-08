package game;

import data.Card;
import data.Rank;
import data.Suit;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PokerHand {

    Card[] cards;

    Map<Rank, Integer> rankMap;

    Map<Suit, Integer> suitMap;

    public PokerHand(Card[] cards) {
        Arrays.sort(cards);
        this.cards = cards;
        initRankMap(cards);
    }

    public Card[] getCards() {
        return cards;
    }

    public Map<Rank, Integer> getRankMap() {
        return rankMap;
    }

    public Map<Suit, Integer> getSuitMap() {
        return suitMap;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Card card: this.cards) {
            builder.append(card.toString()).append(" ");
        }
        return builder.toString();
    }

    public String debugCounts() {
        StringBuilder builder = new StringBuilder();
        rankMap.forEach(((rank, integer) -> {
            builder.append("R").append(rank).append(":").append(integer).append(" ");
        }));
        builder.append("\n");
        suitMap.forEach(((suit, integer) -> {
            builder.append(suit).append(":").append(integer).append(" ");
        }));
        return builder.toString();
    }

    private void initRankMap(Card[] cards) {
        Map<Suit, Integer> initSuitMap = new TreeMap<>();
        Map<Rank, Integer> initRankMap = new TreeMap<>();
        for (Card card : cards) {
            Rank rank = card.getRank();
            Suit suit = card.getSuit();
            int rankCount = initRankMap.get(rank) == null ? 0 : initRankMap.get(rank);
            int suitCount = initSuitMap.get(suit) == null ? 0 : initSuitMap.get(suit);
            initRankMap.put(rank, rankCount + 1);
            initSuitMap.put(suit, suitCount + 1);
        }
        this.suitMap = initSuitMap;
        this.rankMap = initRankMap;
    }
}
