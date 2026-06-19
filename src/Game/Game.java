package Game;
import java.util.ArrayList;
import java.util.Collections;

import Cards.*;

public class Game {
    ArrayList<Card> deck = new ArrayList<>();
    ArrayList<Card> discard = new ArrayList<>();
    Player player1;
    Player player2;

    int currentRound;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }
    public void createDeck() {

        //Create 6 of each card type
        for (int i = 0; i < 7; i++) {
            deck.add(new Sword());
            deck.add(new Cannon());
            deck.add(new Chest());
            deck.add(new Hook());
            deck.add(new Key());
            deck.add(new Map());
            deck.add(new Mermaid());
            deck.add(new Oracle());
            }
        }

    

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void deal() {
        for (int i = 0; i < 5; i++) {
            player1.hand.add(deck.remove(0));
            player2.hand.add(deck.remove(0));

        }
        


    }
    public Player getPlayer1() {
        return player1;
    }
        public Player getPlayer2() {
        return player2;
    }
}

