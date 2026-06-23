package Game;
import java.util.ArrayList;
import java.util.Collections;

import Cards.*;

public class Game {
    protected ArrayList<Card> deck = new ArrayList<>();
    protected ArrayList<Card> discard = new ArrayList<>();
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player currentOpponent;
    private GameUpdater gameUpdater;

    //1 means its player1s turn and 2 means its player2s turn
    private int currentRound = 1;

    public Game() {
        this.player1 = new Player(this);
        this.player2 = new Player(this);
        this.currentPlayer = player1;
        this.currentOpponent = player2;
    }

    public void addGameUpdater(GameUpdater gameUpdater) {
        this.gameUpdater = gameUpdater;
    }
    public void createDeck() {

        //Create 6 of each card type
        for (int i = 0; i < 7; i++) {
            deck.add(new Sword(this));
            deck.add(new Cannon(this));
            deck.add(new Chest(this));
            deck.add(new Hook(this));
            deck.add(new Key(this));
            deck.add(new Map(this));
            deck.add(new Mermaid(this));
            deck.add(new Oracle(this));
            }
        }

    

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void deal() {
        for (int i = 0; i < 5; i++) {
            player1.getHand().add(deck.remove(0));
            player2.getHand().add(deck.remove(0));

        }

    }
    public void updateScore() {
        gameUpdater.updateTotalPoints();
    }

    //Show alert
    public void showAlert() {
        gameUpdater.duplicateAlert();
    }



    //Find current player and swap to the other player
    public void nextTurn() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
            currentOpponent = player1;
            currentRound = 2;
        }
            else {
                currentPlayer = player1;
                currentOpponent = player2;
                currentRound = 1;
            }
            gameUpdater.updateTotalPoints();
        } 

    public Player getPlayer1() {
        return player1;
    }
    public Player getPlayer2() {
        return player2;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Player getCurrentOpponent() {
        return currentOpponent;
    }
    public ArrayList<Card> getDiscard() {
        return discard;
    }
    public ArrayList<Card> getDeck() {
        return deck;
    }
    public Game getGame() {
        return this;
    }
    public int getCurrentRound() {
        return currentRound;
    }


}

