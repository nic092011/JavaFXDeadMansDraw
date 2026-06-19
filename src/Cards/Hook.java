package Cards;



import UI.ImageLoader;
import javafx.scene.image.Image;

public class Hook extends Card{

        public Hook() {
        super(CardType.HOOK, ImageLoader.CHEST);
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
