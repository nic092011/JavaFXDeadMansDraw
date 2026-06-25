package Cards;


import java.util.ArrayList;
import java.util.Collections;

import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Map extends Card{


        public Map(Game game) {
        super(CardType.MAP, ImageLoader.MAP, game);


    }


 


    //Draw 3 cards from discard and choose one to add to play area
    @Override
    public Boolean useAbility() {

        ArrayList<Card> discard = game.getDiscard();
        int end = Math.min(3, discard.size());
        Collections.shuffle(discard);

        ArrayList<Card> mapList = new ArrayList<Card>(discard.subList(0, end) );

        game.showMapCards(mapList);
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
        return "Map - Draw 3 cards from the discard pile and pick one to add to the play area:";
    }

}
