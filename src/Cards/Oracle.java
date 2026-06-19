package Cards;


import UI.ImageLoader;
import javafx.scene.image.Image;

public class Oracle extends Card{


    public Oracle() {
        super(CardType.ORACLE, ImageLoader.ORACLE);
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



