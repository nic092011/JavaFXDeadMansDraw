package Game;


import UI.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Main extends Application {

    Button deal = new Button("Deal");

    Game game = new Game();

    GameView gameView = new GameView(game);
    GameUpdater gameUpdater = new GameUpdater(gameView);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        // Stage is the enite Window
        primaryStage.setTitle("Dead Mans Draw");

        game.addGameUpdater(gameUpdater);
        game.giveStage(primaryStage);
        Scene scene = new Scene(gameView.getRoot(), 1200, 800);
        scene.getStylesheets().add("Styles/game.css");
        
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
