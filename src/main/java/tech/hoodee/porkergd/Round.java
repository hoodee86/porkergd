package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

enum Status {
    PLAYING,
    OVER;
};

public class Round {
    private Player[] players;                  // 当前局的玩家
    private List<Hand> hands;                     // 当前局的每轮出牌记录
    private int level;                            // 当前局的牌级 2-A
    private Player[] initOrderPlayers;              // 初始的赢家顺序
    private Player[] finalOrderPlayers;              // 经过本局后，赢家顺序
    private Status status;                       // 当前局的状态


    public Round(Player[] players, int level, Player[] initOrderPlayers) {
        this.players = players;
        this.hands = new ArrayList<>();
        this.level = level;
        this.initOrderPlayers = initOrderPlayers;
        this.finalOrderPlayers = new Player[initOrderPlayers.length];
        this.status = Status.PLAYING;
    }

    public int nextRoundLevel(Map<Integer, Integer> playerLevel) {    
        if (Status.OVER == status) {
            if (finalOrderPlayers[0].getPosition() == Position.SOUTH) {
               if (finalOrderPlayers[1].getPosition() == Position.NORTH) {
                    return playerLevel.get(3) + 3;
                } else if (finalOrderPlayers[2].getPosition() == Position.NORTH) {
                    return playerLevel.get(3) + 2;
                } else if (finalOrderPlayers[3].getPosition() == Position.NORTH) {
                    return playerLevel.get(3) + 1;
                }
            } else if (finalOrderPlayers[0].getPosition() == Position.EAST) {
                if (finalOrderPlayers[1].getPosition() == Position.SOUTH) {
                    return playerLevel.get(0) + 3;
                } else if (finalOrderPlayers[2].getPosition() == Position.SOUTH) {
                    return playerLevel.get(0) + 2;
                } else if (finalOrderPlayers[3].getPosition() == Position.SOUTH) {
                    return playerLevel.get(0) + 1;
                }
            } else if (finalOrderPlayers[0].getPosition() == Position.NORTH) {
                if (finalOrderPlayers[1].getPosition() == Position.WEST) {
                    return playerLevel.get(1) + 3;
                } else if (finalOrderPlayers[2].getPosition() == Position.WEST) {
                    return playerLevel.get(1) + 2;
                } else if (finalOrderPlayers[3].getPosition() == Position.WEST) {
                    return playerLevel.get(1) + 1;
                }
            } else if (finalOrderPlayers[0].getPosition() == Position.WEST) {
                if (finalOrderPlayers[1].getPosition() == Position.NORTH) {
                    return playerLevel.get(2) + 3;
                } else if (finalOrderPlayers[2].getPosition() == Position.NORTH) {
                    return playerLevel.get(2) + 2;
                } else if (finalOrderPlayers[3].getPosition() == Position.NORTH) {
                    return playerLevel.get(2) + 1;
                }
            }
        } 
        return level; 
    }

    public Player getInitStartPlayer() {
        return initOrderPlayers[0];
    }

    public Player getFinalStartPlayer() {
        return finalOrderPlayers[0];
    }

    public Player[] getInitOrderPlayers() {
        return initOrderPlayers;
    }
    public Player[] getFinalOrderPlayers() {
        return finalOrderPlayers;
    }

    public int getLevel() {
        return level;
    }

    /* 
    public boolean nextRound(Player startPlayer, CardType cardType, Card[] cards) {
        Hand hand = new Hand(players, startPlayer, cardType, cards);
        this.hands.add(hand);
        return true;
    }*/

}
