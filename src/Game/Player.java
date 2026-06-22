package Game;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

import Cards.Card;

public class Player {

    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> bank = new ArrayList<>();
    ArrayList<Card> playArea = new ArrayList<>();

    String name;
    int currentScore;

    public void addToBank() {
        bank.addAll(playArea);
    }

     
    public ArrayList<Card> getHand() {
        return hand;
    }


    public void addToPlayArea(Card card) {
        int index = hand.indexOf(card);
        playArea.add(hand.remove(index));
        card.useAbility();
    }



}
