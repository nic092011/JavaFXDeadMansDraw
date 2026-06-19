package Cards;



import javafx.scene.image.Image;

public class Key extends Card{

    private final Image key = new Image(getClass().getResource("/images/Key.png").toExternalForm());

        public Key() {
        super("Key");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public Image getImage() {
        return key;
    }

}
