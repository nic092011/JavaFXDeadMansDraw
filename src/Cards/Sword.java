package Cards;

import javafx.scene.image.Image;

public class Sword extends Card {
        private final Image sword = new Image(getClass().getResource("/images/Sword.png").toExternalForm());


    public Sword() {
        super("Sword");
    }


    @Override
    public Boolean useAbility() {
        return true;
    }


    @Override
public Image getImage() {
    return sword;
}

}
