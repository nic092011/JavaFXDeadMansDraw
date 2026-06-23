package Cards;


import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Hook extends Card{

        public Hook(Game game) {
        super(CardType.HOOK, ImageLoader.HOOK, game);
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
        return "Hook - Select a highest-value card from your Bank:";
    }
    
    
}
