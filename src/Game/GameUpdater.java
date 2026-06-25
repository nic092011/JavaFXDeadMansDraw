package Game;

import java.util.ArrayList;

import Cards.Card;
import UI.GameView;

public class GameUpdater {

    private GameView gameView;

    GameUpdater(GameView gameView) {
        this.gameView = gameView;
    }

    public void updateTotalPoints() {
        gameView.updatePlayerPoints();
    }

    public void duplicateAlert() {
        gameView.showAlert("Duplicate cards in Play Area!", "When two of the same cards are added to the play area, all cards are moved to the discard pile.");
        gameView.clearPlayArea();
    }

    public void showMapCards(ArrayList<Card> cardsToShow) {
        gameView.showCards(cardsToShow);
    }

}
