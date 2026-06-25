package UI;

import Cards.Card;
import Game.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

//Displays the play area section. Creates player and card views
public class GameView {

    private BorderPane root = new BorderPane();

    // Center play area that both players use
    private HBox playAreaBox = new HBox(10);
    private HBox centerBox = new HBox(10);

    private Button deal = new Button("Deal");

    private Game game;
    private PlayerView playerView;
    private CardView cardView;

    private HBox p1HandHBox = new HBox(10);

    private HBox p2HandHBox = new HBox(10);

    public GameView(Game game) {

        this.game = game;

        // Set the Cards and button position
        root.setCenter(deal);

        // Create player and card views
        this.playerView = new PlayerView(game, this);
        this.cardView = new CardView(this);

        deal.setOnAction(e -> dealCards());
    }

    // Creates and Shuffles Deck and displayes hand
    private void dealCards() {

        game.createDeck();
        game.shuffleDeck();
        //Give each player 5 cards
        game.deal();
        //Add each hand to the screen
        showHands();
        showBankButton();
        playerView.showPlayerPoints(p1HandHBox, p2HandHBox);
        root.getChildren().remove(deal);
    }

    private void showHands() {
        p1HandHBox = playerView.showHands(1, p1HandHBox);
        p2HandHBox = playerView.showHands(2, p2HandHBox);
        
        root.setBottom(p1HandHBox);

        root.setTop(p2HandHBox);
    }

    // show the bank button
    private void showBankButton() {

        // Create and add event listener to bank button
        Button bankButton = new Button("Add to Bank");
        bankButton.setOnAction(e -> {

            game.getCurrentPlayer().addToBank();
            playAreaBox.getChildren().clear();

            // update the current points label
            playerView.updatePointLabel(1, p1HandHBox);
            playerView.updatePointLabel(2, p2HandHBox);
            game.nextTurn();

        });

        // Add button to players hand area
        centerBox.setAlignment(Pos.CENTER_RIGHT);
        centerBox.getChildren().add(bankButton);

    }

    // After card is picked, Move card to center and remove from players hand
    public void moveToPlayArea(StackPane cardPane, Card card) {

        if (!game.getCurrentPlayer().addToPlayArea(card)) {
            return;
        }

        playAreaBox.getChildren().add(cardPane);
        playAreaBox.setAlignment(Pos.CENTER);

        centerBox.getChildren().add(playAreaBox);
        root.setCenter(centerBox);

    }

    // Alert with parameters title and message
    public void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    // Method to clear the cards from the play area
    public void clearPlayArea() {
        playAreaBox.getChildren().clear();
        
    }

    public CardView getCardView() {
        return cardView;
    }

    public BorderPane getRoot() {
        return root;
    }

    public PlayerView getPlayerView() {
        return playerView;
    }

    public void updatePlayerPoints() {
        // update the current points label
        playerView.updatePointLabel(1, p1HandHBox);
        playerView.updatePointLabel(2, p2HandHBox);

    }
}