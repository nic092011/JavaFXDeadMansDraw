package UI;

import javafx.scene.control.Label;

import Game.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class GameView {

    private BorderPane root = new BorderPane();

    private VBox p1vbox = new VBox();
    private VBox p2vbox = new VBox();

    private HBox p1HandHBox = new HBox(10);
    private HBox p2HandHBox = new HBox(10);

    private Button deal = new Button("Deal");
 


    private Game game;

    public GameView(Game game) {

        this.game = game;

        root.setCenter(deal);
        root.setTop(p2vbox);
        root.setBottom(p1vbox);

        deal.setOnAction(e -> dealCards());
    }

    private void dealCards() {

        game.createDeck();
        game.shuffleDeck();
        game.deal();
        showHands();
    }

    private void showHands() {
        //Add cards to the HBox
        p1HandHBox.getChildren().addAll(game.getPlayer1().printHand());
        p2HandHBox.getChildren().addAll(game.getPlayer2().printHand());


        //Add cards HBox to player area
        p1vbox.getChildren().add(p1HandHBox);
        p2vbox.getChildren().add(p2HandHBox);


        //Align all vbox and hbox

        p1HandHBox.setAlignment(Pos.CENTER);
        p2HandHBox.setAlignment(Pos.CENTER);

        //Set inside borderPane
        root.setBottom(p1vbox);
        root.setTop(p2vbox);


    }

    public BorderPane getRoot() {
        return root;
    }
}