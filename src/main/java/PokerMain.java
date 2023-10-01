import game.PokerHand;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import pokerhands.PokerHandFactory;

public class PokerMain {

    private static final Logger logger = LogManager.getLogger(PokerMain.class);

    public static void main(String[] args) {
        logger.info("Starting Poker Game");
        System.out.println("--------------------------------");
        System.out.println("Welcome to Poker!");
        System.out.println("--------------------------------");
//        int choice = Menu.startMenu();
        PokerHandFactory pokerHandFactory = new PokerHandFactory();
        PokerGame game = new PokerGame();
//        game.printDeck();
        PokerHand playerPokerHand = pokerHandFactory.dealPokerHand(game.dealCards(5));
        System.out.println("Your Hand: " + playerPokerHand);

        PokerHand aiPokerHand = pokerHandFactory.dealPokerHand(game.dealCards(5));
        System.out.println("Game Hand: " + aiPokerHand);

        game.addCardsBackToDeck(playerPokerHand);
        game.addCardsBackToDeck(aiPokerHand);

    }
}
