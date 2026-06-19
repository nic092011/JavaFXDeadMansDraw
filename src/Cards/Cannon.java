package Cards;



import javafx.scene.image.Image;

public class Cannon extends Card {
        private final Image cannon = new Image(getClass().getResource("/images/Cannon.png").toExternalForm());

    public Cannon() {
        super("Cannon");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public Image getImage() {
        return cannon;
    }
}
