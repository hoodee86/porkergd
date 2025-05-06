package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {
    private CardBox cardBox;                        // 牌盒里面有两副牌
    private Player[] players;                       // 4个玩家，东北西南 0123
    private Map<Integer, Integer> playerLevel;     // 玩家的等级
    private List<Round> rounds ;                    // 当前牌局的回合队列
    private Round currentRound;                     // 当前回合

    public Game(Player[] players) {
        this.cardBox = new CardBox();
        this.players = players;
        playerLevel = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            playerLevel.put(i, 2); // 默认等级为2
        }
        rounds = new ArrayList<>();
        currentRound = null;
    }

    public Game() {
        this.cardBox = new CardBox();
        this.players = new Player[4];
        playerLevel = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            players[i] = new Player(Position.values()[i]);
            playerLevel.put(i, 2); // 默认等级为2
        }
        rounds = new ArrayList<>();
        currentRound = null;
    }

    public void shuffle() {
        cardBox.shuffle();
    }

    public void nextRound() {
        // 开始洗牌
        shuffle();
        // 开始发牌
        dealCards();
        for (Player player : players) {
            System.out.println(player.getName() + "的手牌：");
            for (Card card : player.getPocket()) {
                System.out.println(card);
            }
            System.out.println("-------------------------------");
        } 
        if (currentRound == null) {
            currentRound = new Round(players, 2, players);
            rounds.add(currentRound);
        } else {
            Player[] initOrderPlayers = currentRound.getFinalOrderPlayers();
            int level = currentRound.nextRoundLevel(playerLevel);
            currentRound = new Round(players, level, initOrderPlayers);
            rounds.add(currentRound);
        }
        
    }

    public void dealCards() {
        for (int i = 0; i < cardBox.getCardCount(); i++) {
            Player player = players[i % 4];
            player.receiveOneCard(cardBox.dealOneCard());
        }
    }

    public Player[] getPlayers() {
        return players;
    }
}
