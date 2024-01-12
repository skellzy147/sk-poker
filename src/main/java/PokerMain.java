import game.PokerHand;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import game.PokerHandFactory;

public class PokerMain {

    private static final Logger logger = LogManager.getLogger(PokerMain.class);

    public static void main(String[] args) {
        logger.info("Starting Poker Game");
        System.out.println("--------------------------------");
        System.out.println("Welcome to Poker!");
        System.out.println("--------------------------------");

        PokerHandFactory pokerHandFactory = new PokerHandFactory();

        PokerGame game = new PokerGame();
        PokerHand playerPokerHand = pokerHandFactory.dealPokerHand(game.dealCards(5));
        System.out.println("Your Hand: " + playerPokerHand);

        PokerHand aiPokerHand = pokerHandFactory.dealPokerHand(game.dealCards(5));
        System.out.println("Game Hand: " + aiPokerHand);

        double playerHandValue = playerPokerHand.getHandEvaluation().getValue();
        double aiHandValue = aiPokerHand.getHandEvaluation().getValue();

        if (playerHandValue > aiHandValue) {
            System.out.println("You Win!");
        } else if (aiHandValue > playerHandValue) {
            System.out.println("AI Wins!");
        } else {
            System.out.println("Draw!");
        }

        game.addCardsBackToDeck(playerPokerHand);
        game.addCardsBackToDeck(aiPokerHand);

    }
}
