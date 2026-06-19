package Cards;



import UI.ImageLoader;
import javafx.scene.image.Image;

public class Key extends Card{


        public Key() {
        super(CardType.KEY, ImageLoader.KEY);
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
        return "Key - No immediate effect. If banked with a Chest, draw as many cards from the Discard pile as you moved to your Bank.";
    }

}
