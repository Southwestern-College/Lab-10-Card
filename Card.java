/**
 * Represents a mutable playing card whose state may change only through
 * controlled card-enhancement operations.
 *
 * @author YOUR NAME
 */
public class Card {
    // Class Constants
    public static final char HEART = '♥';
    public static final char DIAMOND = '♦';
    public static final char CLUB = '♣';
    public static final char SPADE = '♠';

    public static final int DEFAULT_VALUE = 1;
    public static final char DEFAULT_SUIT = HEART;

    // Instance Variables
    private int value;
    private char suit;

    /**
     * Creates a card with the default value and suit.
     */
    public Card() {
        // TODO: Initialize both instance variables.
    }

    /**
     * Creates a card with the specified value and suit. If either argument is
     * invalid, both instance variables must use their default values.
     *
     * @param value the card value from 1 through 13
     * @param suit one of the four suit constants
     */
    public Card(int value, char suit) {
        // TODO: Validate both arguments before initializing the card.
    }

    /**
     * Determines whether a numeric card value is valid.
     *
     * @param value the value to validate
     * @return true when value is from 1 through 13; otherwise false
     */
    private static boolean isValidValue(int value) {
        return false; // TODO
    }

    /**
     * Determines whether a suit is valid.
     *
     * @param suit the suit to validate
     * @return true when suit matches one of the four suit constants
     */
    private static boolean isValidSuit(char suit) {
        return false; // TODO
    }

    /**
     * Returns the card's numeric value.
     *
     * @return the value from 1 through 13
     */
    public int getValue() {
        return 0; // TODO
    }

    /**
     * Returns the card's suit.
     *
     * @return the suit character
     */
    public char getSuit() {
        return '?'; // TODO
    }

    /**
     * Returns the value as it appears on a playing card.
     *
     * @return A, 2 through 10, J, Q, or K
     */
    public String getPrintValue() {
        return ""; // TODO
    }

    /**
     * Increases the card's value by one unless the card is already a king.
     *
     * @return true when the value increases; otherwise false
     */
    public boolean increaseValue() {
        return false; // TODO
    }

    /**
     * Changes the card's suit when the new suit is valid.
     *
     * @param newSuit the requested suit
     * @return true when the requested suit is valid; otherwise false
     */
    public boolean changeSuit(char newSuit) {
        return false; // TODO
    }

    /**
     * Returns the card's printed value and suit separated by one space.
     *
     * @return a compact string representation of the card
     */
    @Override
    public String toString() {
        return ""; // TODO
    }
}
