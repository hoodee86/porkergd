package tech.hoodee.porkergd;

import java.util.Date;
import java.util.List;

public class HandRecord {
    private Player player; // 谁？
    private Date time; // 什么时候？
    private Operation operation; // 做了什么？
    private List<Card> cards;

    public HandRecord(Player player, Operation operation, List<Card> cards) {
        this.player = player;
        this.time = new Date();
        this.operation = operation;
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "RoundRecord{" +
                "player=" + player +
                ", time=" + time +
                ", operation=" + operation +
                '}';
    }
}
