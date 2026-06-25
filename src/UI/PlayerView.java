package UI;


import Game.Game;

import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class PlayerView {
    private Game game;
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



    public void showPlayerPoints(HBox p1HBox, HBox p2HBox, BorderPane root) {
        p1HBox.getChildren().add(p1TotalPoints);
        p2HBox.getChildren().add(p2TotalPoints);

        root.setTop(p2HBox);
        root.setBottom(p1HBox);




    }

}
