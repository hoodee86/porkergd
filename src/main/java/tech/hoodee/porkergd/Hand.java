package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.List;

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

    public Hand(Player[] players, int startPlayer, CardType cardType, Card[] cards) {
        this.byeCount = 0;
        this.players = players;
        this.startPlayer = startPlayer;
        this.currentPlayer = startPlayer;
        this.cardType = cardType;
        this.handRecords = new ArrayList<>();
        this.status = Status.PLAYING;
    }

    /* 判断当前轮是否一直跟 */
    public Player nextPlayer() {
        int nextIndex = (this.currentPlayer + 1) % 4;
        return players[nextIndex];
    }

    public boolean nextHandRecord(int player, Operation operation, CardType cardType, Card[] cards) {
        if (cardType != this.cardType) {
            return false; // 牌型不匹配
        }
        if (this.byeCount >= 3) {
            this.status = Status.OVER;
            return false; // 过牌次数超过3次
        }
        this.currentPlayer = player;
        if (operation == Operation.FOLD) {
            this.byeCount++;
        } else {
            this.byeCount = 0;
        }
        handRecords.add(new HandRecord(currentPlayer, operation, cards));
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
