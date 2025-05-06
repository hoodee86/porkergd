package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

enum Status {
    PLAYING,
    OVER;
};

public class Hand {
    private Player[] players; // 参与本轮的玩家
    private int startPlayer;     // 首发牌玩家
    private int currentPlayer;   // 当前玩家
    private CardType cardType;      // 当前牌的类型
    private List<HandRecord> handRecords; // 回合记录
    private int byeCount; // 过牌次数
    private Status status; // 当前状态

    public Hand(Player[] players, int startPlayer) {
        this.byeCount = 0;
        this.players = players;
        this.startPlayer = startPlayer;
        this.currentPlayer = startPlayer;
        this.cardType = CardType.NONE;
        this.handRecords = new ArrayList<>();
        this.status = Status.PLAYING;
    }

    public boolean next() {
        Operation operation;
        Map<CardType, List<Card>> cards = players[currentPlayer].play();
        if (cards == null) {
            operation = Operation.PASS;
            this.byeCount++;
            handRecords.add(new HandRecord(players[currentPlayer], operation, null));
        } else {
            operation = Operation.DEAL;
            this.byeCount = 0;
            handRecords.add(new HandRecord(players[currentPlayer], operation, cards.values().iterator().next()));
        }
        if (byeCount >= 3) {
            this.status = Status.OVER;
            return false;
        } else {
            this.currentPlayer = (this.currentPlayer + 1) % 4;
        }
        return true;
    }

    public int getStartPlayer() {
        return startPlayer;
    }
    public void setStartPlayer(int startPlayer) {
        this.startPlayer = startPlayer;
    }
    public int getCurrentPlayer() {
        return currentPlayer;
    }
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public CardType getCardType() {
        return cardType;
    }

}
