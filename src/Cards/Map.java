package Cards;



import UI.ImageLoader;
import javafx.scene.image.Image;

public class Map extends Card{

        public Map() {
        super(CardType.MAP, ImageLoader.MAP);
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public CardType getCardType() {
        return type;
    }

}
