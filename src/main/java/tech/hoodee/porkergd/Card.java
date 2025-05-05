package tech.hoodee.porkergd;

public class Card {
    public Card(Value value, Suit suit) {
        this.value = value;
        this.suit = suit;
    }
    private Value value;
    private Suit suit;
    public Value getValue() {
        return value;
    }
    public void setValue(Value value) {
        this.value = value;
    }
    public Suit getSuit() {
        return suit;
    }
    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "value=" + value +
                ", suit=" + suit +
                '}';
    }
}
