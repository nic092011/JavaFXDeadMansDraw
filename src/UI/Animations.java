package UI;

import javafx.animation.TranslateTransition;
import javafx.geometry.Bounds;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class Animations {

    public static void cardFromDeck(StackPane cardPane) {
        TranslateTransition move = new TranslateTransition(Duration.seconds(0.6), cardPane);

        move.setFromX(0);
        move.setFromY(0);

        move.setToX(50);
        move.setToY(0);

        move.play();
    }

    public static void addToBank(StackPane cardPane, HBox playArea, HBox playerBank, Runnable onFinished) {
        

        Bounds start = cardPane.localToScene(cardPane.getBoundsInLocal());
        Bounds end = playerBank.localToScene(playerBank.getBoundsInLocal());

        double dx = end.getMinX() - start.getMinX();
        double dy = end.getMinY() - start.getMinY();

        TranslateTransition move = new TranslateTransition(Duration.millis(600), cardPane);

        move.setByX(dx);
        move.setByY(dy);

        move.setOnFinished(e -> {
            if (onFinished != null) {
                onFinished.run();
            }
        });

        move.play();
    }

}
