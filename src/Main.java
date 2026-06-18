
import java.util.ArrayList;

import Cards.Card;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    Button deal = new Button("Deal");
    Player player1 = new Player();
    Player player2 = new Player();

    Game game = new Game(player1, player2);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Stage is the enite Window
        primaryStage.setTitle("Dead Mans Draw");

        // Layout stuff
        VBox vbox = new VBox();
        ArrayList<Label> cards = new ArrayList<>();

        // Deal button
        deal.setOnAction(e -> {
            game.createDeck();

            for (Card c : game.deck) {
                String title = c.getImage();
                cards.add(new Label(title));

            }
            vbox.getChildren().addAll(cards);

        });

        vbox.getChildren().add(deal);
        

        Scene scene = new Scene(vbox, 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
