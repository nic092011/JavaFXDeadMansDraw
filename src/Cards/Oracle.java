package Cards;

import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Oracle extends Card{


    public Oracle(Game game) {
        super(CardType.ORACLE, ImageLoader.ORACLE, game);
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
        return "Oracle - See the next card in the deck before drawing";
    }

}



