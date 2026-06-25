package UI;

import Cards.Card;
import Game.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class PlayerView {
    private Game game;
    private CardView cardView;
    private GameView gameView;

    // Players total points label
    private Label p1TotalPoints = new Label();
    private Label p2TotalPoints = new Label();

    PlayerView(Game game, GameView gameView) {
        this.game = game;
        this.gameView = gameView;

    }

    // Get bank points from each player and add to HBox
    public void updatePointLabel(int player, HBox handHBox) {
        int points;
        if (player == 1) {
            // Remove the existing label and re add it
            points = game.getPlayer1().getBankPoints();
            p1TotalPoints.setText("Bank Points: " + String.valueOf(points));
        } else {

            points = game.getPlayer2().getBankPoints();
            p2TotalPoints.setText("Bank Points: " + String.valueOf(points));

        }

    }

    // Adds images to HBox and returns to game view //bottom = 1 top = 2
    public HBox showHands(int player, HBox handHBox) {

        cardView = gameView.getCardView();

        // Add cards to the HBox
        if (player == 1) {
            for (Card card : game.getPlayer1().getHand()) {
                handHBox.getChildren().add(cardView.addCardText(card));
            }
        } else if (player == 2) {

            for (Card card : game.getPlayer2().getHand()) {
                handHBox.getChildren().add(cardView.addCardText(card));

            }
        }

        // Align all vbox and hbox
        handHBox.setAlignment(Pos.CENTER);
        return handHBox;

    }

    public void showPlayerPoints(HBox p1HBox, HBox p2HBox) {
        p1HBox.getChildren().add(p1TotalPoints);
        p2HBox.getChildren().add(p2TotalPoints);

    }

}
