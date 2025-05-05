package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.List;

public class CardBox {
    private List<Card> cards;
    private int cardCount = 0;

    public CardBox() {
        this.cards = new ArrayList<>();
        for (Value value : Value.values()) {
            for (Suit suit : Suit.values()) {
                if (value == Value.BlackJoker || value == Value.RedJoker) {
                    continue; // Skip joker for now
                }
                cards.add(new Card(value, suit));
                this.cardCount++;
            }
        }
        cards.add(new Card(Value.BlackJoker, null));
        cards.add(new Card(Value.RedJoker, null));
        this.cardCount += 2;
    }

    public List<Card> getCards() {
        return cards;
    }

    public int getCardCount() {
        return cardCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Card card : cards) {
            sb.append(card.toString()).append("\n");
        }
        return sb.toString();
    }
}
