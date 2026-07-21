# Lab 10: Card Enhancements

![playing cards](.assets/cards.png)

> Art from Balatro, LocalThunk/Playstack, 2024. Profe Soto's screenshot

## Program Description

In this lab, you will create a `Card` class and use it to generate a standard 52-card deck.
This lab is inspired by Balatro is a roguelike deckbuilder game developed by LocalThunk and published by Playstack.
Like the game, you will apply controlled enhancements that change individual cards.

A card's state may change, but only through valid operations provided by the class. This is **encapsulation**: the object protects its data and controls how that data changes.

## Learning Objectives
- Design and implement a Java class
- Create and use objects
- Distinguish class constants from instance variables
- Initialize objects with constructors
- Create and traverse an array of objects

---

## Complete the Lab in Order

Implement and test one part at a time. Later parts depend on earlier parts.

1. Represent a card
2. Display a card
3. Construct valid cards
4. Enhance cards safely
5. Generate and print a deck
6. Demonstrate card enhancements

Run the provided tests after each part.

---

## Part 1: Represent a Card

### Class Constants

The `Card` class includes constants for the four suits:

- `HEART`
- `DIAMOND`
- `CLUB`
- `SPADE`

It also includes:

- `DEFAULT_VALUE`
- `DEFAULT_SUIT`

Constants must be declared with `public static final`.

### Instance Variables

Each `Card` object stores its own value and suit:

```java
private int value;
private char suit;
```

Both instance variables must remain `private`. Code outside the `Card` class must not access them directly.

### Class Invariant

Every `Card` object must always contain:

- A value from `1` through `13`
- One of the four defined suits

| Numeric Value | Printed Value |
|---------------|---------------|
| 1             | A             |
| 2–10          | 2–10          |
| 11            | J             |
| 12            | Q             |
| 13            | K             |

### Default Constructor

```java
public Card()
```

Initializes the card using `DEFAULT_VALUE` and `DEFAULT_SUIT`.

### Accessor Methods

```java
public int getValue()
```

Returns the card's numeric value.

```java
public char getSuit()
```

Returns the card's suit.

---

## Part 2: Display a Card

### `getPrintValue`

```java
public String getPrintValue()
```

Returns the value as it appears on a playing card:

- `A`
- `2` through `10`
- `J`
- `Q`
- `K`

### `toString`

```java
@Override
public String toString()
```

Returns the printed value and suit separated by one space.

Example:

```text
Q ♠
```

---

## Part 3: Construct Valid Cards

### Validation Helpers

Implement the provided private helper methods:

```java
private static boolean isValidValue(int value)
private static boolean isValidSuit(char suit)
```

These methods validate data only. They must not print output or modify an object.

### Full Constructor

```java
public Card(int value, char suit)
```

- If both arguments are valid, initialize the card with them.
- If either argument is invalid, initialize both fields with their default values.
- Do not terminate the program or print an error message.

---

## Part 4: Enhance Cards Safely

Do not create generic setter methods. Cards may change only through the following game-inspired operations.

### Tarot Cards

Tarot Cards are used to modify various aspects of the playing cards in the deck, such as their suit or rank.

#### Strength

![strength tarot card](.assets/Tarot_Strength.webp)

> Increases rank of up to 2 selected cards by 1

#### The World

![strength tarot card](.assets/Tarot_The_World.webp)

> Converts up to 3 selected cards to ♠ Spades

### `increaseValue`

```java
public boolean increaseValue()
```

- Increase the card's value by one.
- Return `true` when the value increases.
- Return `false` when the card is already a king.
- A failed operation must leave the card unchanged.

Example:

```text
9 ♣ → 10 ♣
```

### `changeSuit`

```java
public boolean changeSuit(char newSuit)
```

- If `newSuit` is valid, assign it and return `true`.
- If `newSuit` is invalid, return `false`.
- A failed operation must leave the card unchanged.

Example:

```text
7 ♦ → 7 ♥
```

---

## Part 5: Generate a Standard Deck

Complete the provided method in `Main.java`:

```java
public static Card[] createDeck()
```

Requirements:

- Create a `Card[]` array with exactly 52 elements.
- Use loops to generate every value and suit combination.
- Create each card with the full constructor.
- Include each standard card exactly once.
- Do not create all 52 cards individually.

The provided `suits` array establishes the deck order:

```java
char[] suits = {
    Card.HEART,
    Card.DIAMOND,
    Card.CLUB,
    Card.SPADE
};
```

Complete `printDeck` so that the deck prints 13 cards per row.

Example:

```text
A ♥ 2 ♥ 3 ♥ 4 ♥ 5 ♥ 6 ♥ 7 ♥ 8 ♥ 9 ♥ 10 ♥ J ♥ Q ♥ K ♥
A ♦ 2 ♦ 3 ♦ 4 ♦ 5 ♦ 6 ♦ 7 ♦ 8 ♦ 9 ♦ 10 ♦ J ♦ Q ♦ K ♦
A ♣ 2 ♣ 3 ♣ 4 ♣ 5 ♣ 6 ♣ 7 ♣ 8 ♣ 9 ♣ 10 ♣ J ♣ Q ♣ K ♣
A ♠ 2 ♠ 3 ♠ 4 ♠ 5 ♠ 6 ♠ 7 ♠ 8 ♠ 9 ♠ 10 ♠ J ♠ Q ♠ K ♠
```

---

## Part 6: Demonstrate Card Enhancements

The provided driver selects one card from the completed deck and applies two enhancements:

1. Increase its value.
2. Change its suit.

Example:

```text
Before enhancement: 7 ♥
After enhancement:  8 ♠
```

This demonstrates that:

- Each array element refers to a separate `Card` object.
- Calling a method changes one specific object.
- The `Card` class controls whether a change is valid.

---

## Testing

Use the provided JUnit test to check:

- Encapsulation of the instance variables
- Default and full constructors
- Valid and invalid constructor arguments
- Printed card values
- String formatting
- Successful and unsuccessful enhancements
- Preservation of state after invalid operations
- Creation of all 52 unique cards

Do not modify the tests to make an incorrect implementation pass.

---

## Coding Standards

- Follow the program specifications exactly.
- Use meaningful identifiers and follow Java naming conventions.
- Remove all auto-generated comments and unused code.
- Document code using [JavaDoc](https://www.baeldung.com/javadoc), including:
    - Program/class description
    - Attribution using the `@author` tag.
- Comment only when necessary.
- Format code cleanly and consistently
    - Proper indentation
    - Brace alignment
    - Whitespace for readability
- Ensure prompts and output are clear and properly formatted.


---

## Going Further: Shuffle the Deck

After all required tests pass, shuffle the deck by swapping cards into random positions.

Your shuffle must:

- Change the order of the array
- Preserve all 52 cards
- Avoid changing the value or suit of any card
- Avoid creating a second deck

A shuffle changes **where object references are stored**, not the state of the objects themselves.

After shuffling, print the deck again. As an additional challenge, print the first five cards as a hand.
