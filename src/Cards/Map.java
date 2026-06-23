package Cards;


import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Map extends Card{

        public Map(Game game) {
        super(CardType.MAP, ImageLoader.MAP, game);
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
        return "Map - Draw 3 cards from the discard pile and pick one to add to the play area:";
    }

}
