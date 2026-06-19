package Cards;



import javafx.scene.image.Image;

public class Hook extends Card{
        private final Image hook = new Image(getClass().getResource("/images/Hook.png").toExternalForm());

        public Hook() {
        super("Hook");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public Image getImage() {
        return hook;
    }

}
