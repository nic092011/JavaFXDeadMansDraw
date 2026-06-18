import java.util.ArrayList;

import Cards.Card;

public class Player {

    ArrayList<Card> hand;
    ArrayList<Card> bank;
    ArrayList<Card> playArea;

    String name;
    int currentScore;

    public void addToBank() {
        bank.addAll(playArea);
    }

    

}
