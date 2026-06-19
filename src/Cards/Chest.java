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

    @Override
    public String getAbilityString() {
        return "Chest - No immediate effect. If banked with a key, draw as many cards from the Discard pile as you moved to your Bank.";
    }

}
