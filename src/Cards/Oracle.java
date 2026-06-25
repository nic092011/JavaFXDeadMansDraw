package Cards;

import java.util.ArrayList;

import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Oracle extends Card{


    public Oracle(Game game) {
        super(CardType.ORACLE, ImageLoader.ORACLE, game);
    }


    @Override
    public Boolean useAbility() {

        ArrayList<Card> tempCard = new ArrayList<>(game.getDeck().subList(0, 1));
        game.showMapCards(tempCard);

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



