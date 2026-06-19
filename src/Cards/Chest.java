package Cards;


import UI.ImageLoader;
import javafx.scene.image.Image;

public class Chest extends Card {

    public Chest() {
        super(CardType.CHEST, ImageLoader.CHEST);
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
