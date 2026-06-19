package Cards;



import UI.ImageLoader;
import javafx.scene.image.Image;

public class Key extends Card{


        public Key() {
        super(CardType.KEY, ImageLoader.KEY);
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
