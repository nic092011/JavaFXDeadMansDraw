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
        bank.addAll(playArea);
        bankPoints += getPlayAreaPoints();

        playArea.clear();
    }



    public ArrayList<Card> getBank() {
        return bank;
    }

    public ArrayList<Card> getPlayArea() {
        return playArea;
    }



    // Removes card from hand and adds to play area, and uses card ability
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

    // Calculate the points from the play area
    // NEED TO CHECK FOR CHEST AND KEY
    public int getPlayAreaPoints() {
        int points = 0;
        for (Card card : playArea) {
            points += card.getPointValue();
        }
        return points;
    }

    public int getBankPoints() {
        return bankPoints;
    }

    public void subtractBankPoints(int pointValue) {
        bankPoints -= pointValue;

    }

    public CardType getLastCardType() {
        return playArea.get(playArea.size() - 1).getCardType();
    }

}
