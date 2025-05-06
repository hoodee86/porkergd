package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


// TODO: sort data structure
/*
1）对子：one pair（两张相同点数的牌）
2）三连对：three pair（有两张相同点数的牌，加另外两张相同点数的牌）
3）同花：flush（五张顺连的牌）
4）同花顺：straight flush（五张同一花色且顺连的牌）
5）三条：three of a kind （三张同点数的牌）
6）四条：four of a kind（四张同点数的牌，又叫炸弹）
7）俘虏、葫芦：full house（三张同一点数的牌，加一对其他点数的牌）
8）散牌：high card（不能排成以上组合的牌，以点数决定大小）
9) 3+3
10) five of a kind
11) six of a kind
12) seven of a kind
13) eight of a kind
 */
public class Player {
    private String id;
    private String name;
    private Position position; 
    private List<Card> pocket;

    public Player(String name, Position position) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the player
        this.name = name;
        this.position = position;
        this.pocket = new ArrayList<>(); // card in player's hand, private card queue
    }

    public Player(Position position) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID for the player
        this.name = "Player" + position.getValue();
        this.position = position;
        this.pocket = new ArrayList<>(); // card in player's hand, private card queue
    }

    public void deal(List<Card> cards) {
        for (Card card : cards) {
            this.pocket.remove(card);
        }
    }

    public void fold() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getPocket() {
        return pocket;
    }

    public void setPocket(List<Card> pocket) {
        this.pocket = pocket;
    }

    public void receiveOneCard(Card card) {
        pocket.add(card);
    }
}
