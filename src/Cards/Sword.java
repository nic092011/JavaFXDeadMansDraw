package Cards;

import UI.ImageLoader;
import javafx.scene.image.Image;

public class Sword extends Card {


    public Sword() {
        super(CardType.SWORD, ImageLoader.SWORD);
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
