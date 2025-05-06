package tech.hoodee.porkergd;

import java.sql.Date;

public class HandRecord {
    private Player player; // 谁？
    private Date time; // 什么时候？
    private Operation operation; // 做了什么？
    private Card[] cards;

    public HandRecord(Player player, Operation operation, Card[] cards) {
        this.player = player;
        this.time = new Date(System.currentTimeMillis());
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
