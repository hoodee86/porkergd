package tech.hoodee.porkergd;

public enum Value {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14),
    BlackJoker(15),
    RedJoker(16);

    private final int value;

    Value(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
