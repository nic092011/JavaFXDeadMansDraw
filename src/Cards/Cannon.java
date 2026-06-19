package Cards;



import UI.ImageLoader;
import javafx.scene.image.Image;

public class Cannon extends Card {
        

    public Cannon() {
        super(CardType.CANNON, ImageLoader.CANNON);
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
        return "Cannon - Discards the highest point value card from the opponent bank.";
    }
}
