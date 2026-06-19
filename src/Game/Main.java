package Game;


import java.io.File;

import UI.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    Button deal = new Button("Deal");
    Player player1 = new Player();
    Player player2 = new Player();

    Game game = new Game(player1, player2);

    GameView gameView = new GameView(game);


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Stage is the enite Window
        primaryStage.setTitle("Dead Mans Draw");


        Scene scene = new Scene(gameView.getRoot(), 700, 700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
