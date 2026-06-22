package UI;

import java.util.ArrayList;

import Cards.Card;
import Game.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class GameView {

    private BorderPane root = new BorderPane();

    private VBox p1vbox = new VBox();
    private VBox p2vbox = new VBox();

    private HBox p1HandHBox = new HBox(10);
    private HBox p2HandHBox = new HBox(10);

    private HBox playAreaBox = new HBox(10);

    private Button deal = new Button("Deal");

    private Game game;

    public GameView(Game game) {

        this.game = game;

        // Set the Cards and button position
        root.setCenter(deal);
        root.setTop(p2vbox);
        root.setBottom(p1vbox);

        deal.setOnAction(e -> dealCards());
    }

    // Creates and Shuffles Deck and displayes hand
    private void dealCards() {

        game.createDeck();
        game.shuffleDeck();
        game.deal();
        showHands();
        root.getChildren().remove(deal);
    }

    // Adds images to Vbox and Hbox
    private void showHands() {
        // Add cards to the HBox
        for (Card card : game.getPlayer1().getHand()) {
            p1HandHBox.getChildren().add(addCardText(card));
        }

        for (Card card : game.getPlayer2().getHand()) {
            p2HandHBox.getChildren().add(addCardText(card));

        }

        // Add cards HBox to player area
        p1vbox.getChildren().add(p1HandHBox);
        p2vbox.getChildren().add(p2HandHBox);

        // Align all vbox and hbox

        p1HandHBox.setAlignment(Pos.CENTER);
        p2HandHBox.setAlignment(Pos.CENTER);

        // Set inside borderPane
        root.setBottom(p1vbox);
        root.setTop(p2vbox);


    }

    private StackPane addCardText(Card card) {

        Image img = card.getImage();

        // image sizes and affects
        ImageView iView = new ImageView(img);
        iView.setFitWidth(100);
        iView.setFitHeight(150);

        // Create the number Lable
        Label number = new Label(String.valueOf(card.getPointValue()));
        number.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-color: rgba(0,0,0,0.5);" +
                        "-fx-padding: 2px;");

        StackPane cardView = new StackPane();
        cardView.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        cardView.getChildren().addAll(iView, number);
        StackPane.setAlignment(number, Pos.TOP_LEFT);

        // Tooltip is text for onHover
        Tooltip tooltip = new Tooltip(card.getAbilityString());
        Tooltip.install(iView, tooltip);

        // When card is clicked add to play area
        cardView.setOnMouseClicked(e -> {
            moveToPlayArea(cardView, card);
        });

        return cardView;
    }

    // After card is picked, Move card to center and remove from players hand
    public void moveToPlayArea(StackPane cardView, Card card) {


        playAreaBox.getChildren().add(cardView);
        playAreaBox.setAlignment(Pos.CENTER);
        root.setCenter(playAreaBox);
        game.getPlayer1().addToPlayArea(card);

    }

    public BorderPane getRoot() {
        return root;
    }
}