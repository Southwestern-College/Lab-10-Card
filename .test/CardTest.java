import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void instanceVariablesArePrivate() throws NoSuchFieldException {
        Field valueField = Card.class.getDeclaredField("value");
        Field suitField = Card.class.getDeclaredField("suit");

        assertTrue(Modifier.isPrivate(valueField.getModifiers()),
                "The value instance variable must be private.");
        assertTrue(Modifier.isPrivate(suitField.getModifiers()),
                "The suit instance variable must be private.");
    }

    @Test
    void defaultConstructorUsesDefaultValues() {
        Card card = new Card();

        assertEquals(Card.DEFAULT_VALUE, card.getValue());
        assertEquals(Card.DEFAULT_SUIT, card.getSuit());
    }

    @ParameterizedTest
    @CsvSource({
        "1,  ♥",
        "7,  ♦",
        "10, ♣",
        "13, ♠"
    })
    void fullConstructorAcceptsValidArguments(int value, char suit) {
        Card card = new Card(value, suit);

        assertEquals(value, card.getValue());
        assertEquals(suit, card.getSuit());
    }

    @ParameterizedTest
    @CsvSource({
        "0,  ♥",
        "14, ♠",
        "7,  ?"
    })
    void fullConstructorUsesBothDefaultsWhenEitherArgumentIsInvalid(
            int value, char suit) {
        Card card = new Card(value, suit);

        assertEquals(Card.DEFAULT_VALUE, card.getValue());
        assertEquals(Card.DEFAULT_SUIT, card.getSuit());
    }

    @ParameterizedTest
    @CsvSource({
        "1,  A",
        "2,  2",
        "10, 10",
        "11, J",
        "12, Q",
        "13, K"
    })
    void getPrintValueFormatsCardValues(int value, String expected) {
        Card card = new Card(value, Card.CLUB);

        assertEquals(expected, card.getPrintValue());
    }

    @Test
    void toStringReturnsPrintValueAndSuit() {
        Card card = new Card(12, Card.SPADE);

        assertEquals("Q ♠", card.toString());
    }

    @ParameterizedTest
    @CsvSource({
        "1,  2",
        "9,  10",
        "12, 13"
    })
    void increaseValueChangesNonKingCards(int startingValue, int expectedValue) {
        Card card = new Card(startingValue, Card.HEART);

        assertTrue(card.increaseValue());
        assertEquals(expectedValue, card.getValue());
        assertEquals(Card.HEART, card.getSuit(),
                "Increasing a value must not change the suit.");
    }

    @Test
    void increaseValueDoesNotChangeKing() {
        Card card = new Card(13, Card.DIAMOND);

        assertFalse(card.increaseValue());
        assertEquals(13, card.getValue());
        assertEquals(Card.DIAMOND, card.getSuit());
    }

    @ParameterizedTest
    @CsvSource({
        "♥",
        "♦",
        "♣",
        "♠"
    })
    void changeSuitAcceptsValidSuits(char newSuit) {
        Card card = new Card(7, Card.HEART);

        assertTrue(card.changeSuit(newSuit));
        assertEquals(newSuit, card.getSuit());
        assertEquals(7, card.getValue(),
                "Changing a suit must not change the value.");
    }

    @Test
    void changeSuitRejectsInvalidSuitWithoutChangingCard() {
        Card card = new Card(7, Card.DIAMOND);

        assertFalse(card.changeSuit('?'));
        assertEquals(7, card.getValue());
        assertEquals(Card.DIAMOND, card.getSuit());
    }

    @Test
    void createDeckBuildsAll52UniqueCards() {
        Card[] deck = Main.createDeck();

        assertNotNull(deck);
        assertEquals(52, deck.length);

        Set<String> combinations = new HashSet<>();

        for (int i = 0; i < deck.length; i++) {
            Card card = deck[i];
            assertNotNull(card, "Deck position " + i + " must contain a Card object.");

            assertTrue(card.getValue() >= 1 && card.getValue() <= 13,
                    "Every card must contain a valid value.");
            assertTrue(isStandardSuit(card.getSuit()),
                    "Every card must contain a valid suit.");

            String combination = card.getValue() + ":" + card.getSuit();
            assertTrue(combinations.add(combination),
                    "The deck contains a duplicate card: " + card);
        }

        assertEquals(52, combinations.size());
    }

    private static boolean isStandardSuit(char suit) {
        return suit == Card.HEART
                || suit == Card.DIAMOND
                || suit == Card.CLUB
                || suit == Card.SPADE;
    }
}
