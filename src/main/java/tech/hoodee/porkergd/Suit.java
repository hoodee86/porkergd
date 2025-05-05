package tech.hoodee.porkergd;

public enum Suit {
    HEARTS(0),
    DIAMONDS(1),
    CLUBS(2),
    SPADES(3);

    private final int suit;

    Suit(int suit) {
        this.suit = suit;
    }
    public int getSuit() {
        return suit;
    }
}
