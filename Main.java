/**
 * Generates, prints, and enhances a standard deck of Card objects.
 *
 * @author YOUR NAME
 */
public class Main {

    /**
     * Creates a standard 52-card deck containing each value and suit
     * combination exactly once.
     *
     * @return the completed deck
     */
    public static Card[] createDeck() {
        Card[] deck = new Card[52];
        char[] suits = {
            Card.HEART,
            Card.DIAMOND,
            Card.CLUB,
            Card.SPADE
        };

        int index = 0;

        // TODO: Use nested loops to create and store all 52 Card objects.

        return deck;
    }

    /**
     * Prints every card in the deck with 13 cards per row.
     *
     * @param deck the deck to print
     */
    public static void printDeck(Card[] deck) {
        // TODO: Traverse and print the deck.
    }

    /**
     * Runs the card-enhancement demonstration.
     *
     * @param args command-line arguments are not used
     */
    public static void main(String[] args) {
        Card[] deck = createDeck();

        System.out.println("Standard deck:");
        printDeck(deck);

        Card selectedCard = deck[6];

        System.out.println("\nBefore enhancement: " + selectedCard);
        selectedCard.increaseValue();
        selectedCard.changeSuit(Card.SPADE);
        System.out.println("After enhancement:  " + selectedCard);

        // GOING FURTHER:
        // Shuffle the deck, print it again, and display the first five cards.
    }
}
