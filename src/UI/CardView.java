package UI;

import Cards.Card;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

public class CardView {

    GameView gameView;

    CardView(GameView gameView) {
        this.gameView = gameView;
    }
    
    // Add the point value to the card and add tool tip
    public StackPane addCardText(Card card) {

        Image img = card.getImage();
        StackPane cardPane = new StackPane();

        // image sizes and affects
        ImageView iView = new ImageView(img);
        iView.setFitWidth(150);
        iView.setFitHeight(225);

        // Create the number Lable
        Label number = new Label(String.valueOf(card.getPointValue()));
        number.setStyle(
                "-fx-text-fill: white;" +
                        "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-color: rgba(0,0,0,0.5);" +
                        "-fx-padding: 2px;");

        cardPane.setMaxSize(Region.USE_PREF_SIZE, Region.USE_PREF_SIZE);

        cardPane.getChildren().addAll(iView, number);
        StackPane.setAlignment(number, Pos.TOP_LEFT);

        // Tooltip is text for onHover
        Tooltip tooltip = new Tooltip(card.getAbilityString());
        Tooltip.install(iView, tooltip);

        

        return cardPane;
    }

}
