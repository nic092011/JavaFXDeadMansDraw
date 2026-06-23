package Cards;

import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Sword extends Card {


    public Sword(Game game) {
        super(CardType.SWORD, ImageLoader.SWORD, game);
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

    @Override
    public String getAbilityString() {
        return "Sword - Steal a card from the other player's Bank and put into your Play Area:";
    }

}
