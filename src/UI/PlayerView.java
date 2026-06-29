package UI;


import Cards.Card;
import Game.Game;
import Game.Player;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class PlayerView {
    private Game game;

    // Players total points label
    private Label p1TotalPoints = new Label();
    private Label p2TotalPoints = new Label();

    private HBox p1BankHBox = new HBox(-20);
    private HBox p2BankHBox = new HBox(-20);






    

    PlayerView(Game game) {
        this.game = game;

        p1TotalPoints.getStyleClass().add("total-points");
        p2TotalPoints.getStyleClass().add("total-points");

    }

    // Get bank points from each player and add to HBox
    public void updatePointLabel(int player, HBox handHBox) {
        int points;
        if (player == 1) {
            // Remove the existing label and re add it
            points = game.getPlayer1().getBankPoints();
            p1TotalPoints.setText("Player 1 Bank: " + String.valueOf(points));
            updateBankCards(game.getPlayer1(), p1BankHBox);

        } else {

            points = game.getPlayer2().getBankPoints();
            p2TotalPoints.setText("Player 2 Bank: " + String.valueOf(points));
            updateBankCards(game.getPlayer2(), p2BankHBox);


        }

    }

    //Add all cards from bank onto screen
    private void updateBankCards(Player player, HBox bankHBox) {
        bankHBox.getChildren().clear();
        for (Card card : player.getBank()) {

            Image img = card.getImage();
            ImageView iView = new ImageView(img);
            iView.setFitWidth(50);
            iView.setFitHeight(100);
            bankHBox.getChildren().add(iView);

        }
    }



    public void showPlayerPoints(HBox p1HBox, HBox p2HBox, BorderPane root) {
        p1HBox.getChildren().addAll(p1TotalPoints, p1BankHBox);
        p2HBox.getChildren().addAll(p2TotalPoints, p2BankHBox);

        root.setTop(p2HBox);
        root.setBottom(p1HBox);




    }

}
