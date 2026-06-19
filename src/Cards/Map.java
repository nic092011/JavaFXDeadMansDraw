package Cards;



import javafx.scene.image.Image;

public class Map extends Card{
        private final Image map = new Image(getClass().getResource("/images/Map.png").toExternalForm());

        public Map() {
        super("Map");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public Image getImage() {
        return map;
    }

}
