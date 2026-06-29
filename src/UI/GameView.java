package UI;

import java.util.ArrayList;

import Cards.Card;
import Cards.CardType;
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

//Displays the play area section. Creates player and card views
public class GameView {

    private BorderPane root = new BorderPane();

    // Center play area that both players use
    private HBox playAreaBox = new HBox(10);
    private HBox centerButtonBox = new HBox(10);
    private HBox centerImageBox = new HBox(10);
    private HBox tempCards = new HBox(10);

    private VBox centerVBox = new VBox(10);
    private VBox labelVBox = new VBox();

    private Button deal = new Button("Deal");
    private Button drawButton = new Button("Draw Card");
    private Button bankButton = new Button("Add to Bank");

    private Game game;
    private PlayerView playerView;
    private CardView cardView;

    private HBox p1HandHBox = new HBox(10);

    private HBox p2HandHBox = new HBox(10);
    private Label turnLabel = new Label("Player 1's Turn");

    private Label nextCardLabel;

    public GameView(Game game) {

        this.game = game;

        // Set the Cards and button position
        root.setCenter(deal);

        // Create player and card views
        this.playerView = new PlayerView(game);
        this.cardView = new CardView(this);

        deal.setOnAction(e -> dealCards());

        // Add styles to labels and buttons
        turnLabel.getStyleClass().add("turn-label");
        deal.getStyleClass().add("button-style");
        drawButton.getStyleClass().addAll("button-style", "draw-button");

    }

    // Creates and Shuffles Deck and displayes hand
    private void dealCards() {

        game.createDeck();
        game.shuffleDeck();

        // Show UI buttons and images
        showDrawButton();
        showBankButton();
        showDeck();
        playerView.showPlayerPoints(p1HandHBox, p2HandHBox, root);
        root.getChildren().remove(deal);

        centerVBox.getChildren().addAll(turnLabel, labelVBox, centerImageBox, centerButtonBox);
        CardAbilityView.addLabelToScreen(labelVBox);
        root.setCenter(centerVBox);
        centerVBox.setAlignment(Pos.CENTER);

    }

    // Get back of card image and add to center Image Box
    private void showDeck() {
        Image img = ImageLoader.BACK;
        ImageView imageView = new ImageView(img);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        centerImageBox.getChildren().add(imageView);
        centerImageBox.setAlignment(Pos.CENTER);

        centerImageBox.getChildren().add(playAreaBox);

    }

    private void showDrawButton() {
        centerButtonBox.getChildren().add(drawButton);

        drawButton.setOnAction(e -> {
            // when temp cards are displayed then remove when clicked
            removeTempCards();

            Card drawn = game.drawCard();

            StackPane cardPane = cardView.addCardText(drawn);
            
            moveToPlayArea(cardPane, drawn);

            checkIfPlayable(drawn);


        });
    }

    private void checkIfPlayable(Card card) {
            boolean succesful = game.getCurrentPlayer().addToPlayArea(card);

            if (!succesful) {
                game.showAlert();
                game.nextTurn();
                CardAbilityView.clearLabel();
                updateTurnLabel();
            }
    }

    // Removes the temp cards displayed by card abilities
    private void removeTempCards() {
        centerVBox.getChildren().remove(tempCards);
        tempCards.getChildren().clear();
        centerVBox.getChildren().remove(nextCardLabel);
    }

    private void updateTurnLabel() {
        String player = String.valueOf(game.getCurrentRound());
        turnLabel.setText("Player " + player + "'s Turn");

    }

    // show the bank button
    private void showBankButton() {

        // Create and add event listener to bank button
        bankButton.getStyleClass().addAll("button-style", "bank-button");

        bankButton.setOnAction(e -> {
            // when temp cards are displayed then remove when clicked
            removeTempCards();

            game.getCurrentPlayer().addToBank();
            playAreaBox.getChildren().clear();

            // update the current points label
            playerView.updatePointLabel(1, p1HandHBox);
            playerView.updatePointLabel(2, p2HandHBox);
            game.nextTurn();
            CardAbilityView.clearLabel();
            updateTurnLabel();

        });

        // Add button to players hand area
        centerButtonBox.setAlignment(Pos.CENTER);
        centerButtonBox.getChildren().add(bankButton);

    }

    // After card is picked, Move card to center and remove from players hand
    public void moveToPlayArea(StackPane cardPane, Card card) {

        CardAbilityView.showAbility(labelVBox, card);

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

    // Print a list of Cards to the view
    public void showCards(ArrayList<Card> cardsToShow) {

        for (Card card : cardsToShow) {
            // Add to play area when card is clicked
            StackPane cardPane = cardView.addCardText(card);
            // If last card drawn is oracle then it does not have to be clickable
            if (game.getCurrentPlayer().getLastCardType() == CardType.ORACLE) {

                nextCardLabel = new Label("Oracle see's a " + card.getCardType() + ". Draw next card or Add to Bank?");
                centerVBox.getChildren().add(nextCardLabel);

            } else {
                // If card is clicked then move to play area
                cardPane.setOnMouseClicked(e -> {
                    removeTempCards();
                    moveToPlayArea(cardPane, card);
                    checkIfPlayable(card);
                    game.getDiscard().remove(card);



                });
            }

            tempCards.getChildren().add(cardPane);
        }
        tempCards.setAlignment(Pos.CENTER);
        centerVBox.getChildren().add(tempCards);

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