package Game;

import java.util.ArrayList;

import Cards.Card;
import Cards.CardType;

public class Player {

    private final ArrayList<Card> bank = new ArrayList<>();
    private final ArrayList<Card> playArea = new ArrayList<>();
    Game game;
    private int bankPoints;

    Player(Game game) {
        this.game = game;
    }

    String name;
    int currentScore;

    // Add playarea cards to bank and remove from playArea
    public void addToBank() {

        checkChestnKey();
        
        bank.addAll(playArea);
        getBankPoints();

        playArea.clear();
    }

    //if chest and key in is banked. Take from discard number of cards you banked 
    private boolean checkChestnKey() {
        boolean chest = false;
        boolean key = false;
        for (Card card : playArea) {
            if (card.getCardType() == CardType.CHEST) {
                chest = true;
            }
            if (card.getCardType() == CardType.KEY) {
                key = true;
            }
        }

        if (chest && key) {

            int cardCount = playArea.size() >= game.discard.size() ? game.discard.size() : playArea.size();
            if(game.getDiscard().size() < 1) {
                return false;
            }
            for (int i = 0; i < cardCount; i++) {
                bank.add(game.getDiscard().remove(0));
                game.updateScore();
            }
            return true;
        }
        else {
            return false;
        }

    }

    public ArrayList<Card> getBank() {
        return bank;
    }

    public ArrayList<Card> getPlayArea() {
        return playArea;
    }

    // Adds card to play area, uses card ability. displays card ability
    public boolean addToPlayArea(Card card) {

        // Check for duplicate card
        for (Card cardCheck : playArea) {
            if (cardCheck.getCardType() == card.getCardType()) {
                duplicateCardError();

                return false;
            }
        }

        playArea.add(card);

        card.useAbility();

        return true;
    }

    // duplicate Card Error when player tries to add duplicate card to play area
    public void duplicateCardError() {

        // move all cards from play area into discard pile
        game.getDiscard().addAll(playArea);
        playArea.clear();

    }


    public int getBankPoints() {
        int points = 0;
        for (Card card : bank) {
            points += card.getPointValue();

        }
        bankPoints = points;
        return bankPoints;
    }

    

    public CardType getLastCardType() {
        return playArea.get(playArea.size() - 1).getCardType();
    }
}
