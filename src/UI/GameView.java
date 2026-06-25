package UI;

import Cards.Card;
import Game.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

//Displays the play area section. Creates player and card views
public class GameView {

    private BorderPane root = new BorderPane();

    // Center play area that both players use
    private HBox playAreaBox = new HBox(10);
    private HBox centerBox = new HBox(10);

    private VBox centerVBox = new VBox(10);

    private Button deal = new Button("Deal");
    private Button drawButton = new Button("Draw Card");

    private Game game;
    private PlayerView playerView;
    private CardView cardView;

    private HBox p1HandHBox = new HBox(10);

    private HBox p2HandHBox = new HBox(10);
    private Label turnLabel = new Label("Player 1's Turn");
    private Font titleFont = Font.font("Arial", 26);

    public GameView(Game game) {

        this.game = game;

        // Set the Cards and button position
        root.setCenter(deal);

        // Create player and card views
        this.playerView = new PlayerView(game, this);
        this.cardView = new CardView(this);

        deal.setOnAction(e -> dealCards());

        turnLabel.setFont(titleFont);
    }

    // Creates and Shuffles Deck and displayes hand
    private void dealCards() {

        game.createDeck();
        game.shuffleDeck();

        showDrawButton();
        showBankButton();
        showDeck();
        playerView.showPlayerPoints(p1HandHBox, p2HandHBox, root);
        root.getChildren().remove(deal);
        centerVBox.getChildren().add(turnLabel);

        centerVBox.getChildren().add(centerBox);
        root.setCenter(centerVBox);
        centerVBox.setAlignment(Pos.CENTER);

    }

    private void showDeck() {
        Image img = ImageLoader.BACK;
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        centerBox.getChildren().add(imageView);
        centerBox.setAlignment(Pos.CENTER);

        centerBox.getChildren().add(playAreaBox);


    }

    private void showDrawButton() {
        centerBox.getChildren().add(drawButton);

        drawButton.setOnAction(e -> {
            Card drawn = game.drawCard();

            StackPane cardPane = cardView.addCardText(drawn);
            moveToPlayArea(cardPane);

            boolean succesful = game.getCurrentPlayer().addToPlayArea(drawn);

            if(!succesful) {
                game.showAlert();
                game.nextTurn();
                updateTurnLabel();
            }


        });
    }

    private void updateTurnLabel() {
        String player = String.valueOf(game.getCurrentRound());
        turnLabel.setText("Player " + player + "'s Turn");
        
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
            updateTurnLabel();

        });

        // Add button to players hand area
        centerBox.setAlignment(Pos.CENTER_RIGHT);
        centerBox.getChildren().add(bankButton);

    }

    // After card is picked, Move card to center and remove from players hand
    public void moveToPlayArea(StackPane cardPane) {


        playAreaBox.getChildren().add(cardPane);
        playAreaBox.setAlignment(Pos.CENTER);


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