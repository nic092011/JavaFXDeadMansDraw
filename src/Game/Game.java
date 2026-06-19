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
        for (int i = 0; i < 7; i++) {
            deck.add(new Sword());
        }
        for (int i = 0; i < 7; i++) {
            deck.add(new Oracle());
        }
                for (int i = 0; i < 7; i++) {
            deck.add(new Cannon());
        }
                for (int i = 0; i < 7; i++) {
            deck.add(new Chest());
        }
                for (int i = 0; i < 7; i++) {
            deck.add(new Key());
        }
                for (int i = 0; i < 7; i++) {
            deck.add(new Map());
        }
                for (int i = 0; i < 7; i++) {
            deck.add(new Mermaid());
        }
                for (int i = 0; i < 7; i++) {
            deck.add(new Hook());
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

