package Cards;


import javafx.scene.image.Image;

public class Chest extends Card {
    private final Image chest = new Image(getClass().getResource("/images/Chest.png").toExternalForm());

    public Chest() {
        super("Chest");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public Image getImage() {

        return chest;
    }

}
