import game.Hand;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class PokerMain {

    private static final Logger logger = LogManager.getLogger(PokerMain.class);

    public static void main(String[] args) {
        logger.info("Starting Poker Game");
        System.out.println("--------------------------------");
        System.out.println("Welcome to Poker!");
        System.out.println("--------------------------------");
//        int choice = Menu.startMenu();
        PokerGame game = new PokerGame();
//        game.printDeck();
        Hand playerHand = new Hand(game.dealCards(5));
        System.out.println("Your Hand: " + playerHand);
        Hand aiHand = new Hand(game.dealCards(5));
        System.out.println("Game Hand: " + aiHand);
    }
}
