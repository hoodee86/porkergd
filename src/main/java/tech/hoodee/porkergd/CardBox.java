package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

// 掼蛋的牌盒，用于牌的洗牌，发牌
public class CardBox {
    private List<Card> cards; // 牌
    private int cardCount = 0; // 牌的数量

    public CardBox() {
        this.cards = new ArrayList<>();
        List<Card> pack1 = new Pack().getCards();
        List<Card> pack2 = new Pack().getCards();
        cards.addAll(pack1);
        cards.addAll(pack2);
        cardCount = cards.size();
    }

    public List<Card> getCards() {
        return cards;
    }

    // 洗牌
    public List<Card> shuffle() {
        long seed = System.currentTimeMillis();
        Collections.shuffle(cards, new Random(seed));
        return cards;
    }

    public Card dealOneCard() {
        if (cards.size() > 0) {
            return cards.removeFirst();
        }
        return null;
    }

    public int getCardCount() {
        return cardCount;
    }

    @Override
    public String toString() {
        return "GDCardBox{" +
                "cards=" + cards +
                ", cardCount=" + cardCount +
                '}';
    }
}
