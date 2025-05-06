package tech.hoodee.porkergd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

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

    public Map<CardType, List<Card>> play() {
        Scanner scanner = new Scanner(System.in);
        Map<CardType, List<Card>> dealtCards = new HashMap<>();
        System.out.println("current player: " + name);
        System.out.println("1. deal   2. pass");
        String action = scanner.nextLine();
        if (action.equals("pass")) {
            scanner.close();
            return null;
        } else {
            System.out.println("Enter card index (or type '-1' to finish):");
            List<Card> cards = new ArrayList<>();
            while (true) {           
                int cardIndex = Integer.parseInt(scanner.nextLine());
                if (cardIndex == -1) {
                    break;
                }
                cards.add(pocket.get(cardIndex));
                pocket.remove(cardIndex);
            }
            CardType cardType = Rule.getCardType(cards);
            dealtCards.put(cardType, cards);
            scanner.close();
            return dealtCards;
        }
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
