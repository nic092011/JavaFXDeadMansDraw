package UI;

import Cards.Card;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public  class CardAbilityView {
    private static Label cardLabel = new Label();

    public static void addLabelToScreen(VBox labelVBox) {
        labelVBox.getChildren().add(cardLabel);
        labelVBox.setAlignment(Pos.TOP_CENTER);
        cardLabel.getStyleClass().add("total-points");

    }

    public static void showAbility(VBox labelVBox, Card card) {
        cardLabel.setText(card.getAbilityString());
    }

    public static void clearLabel() {
        cardLabel.setText("");
    }

}
