package Cards;


import UI.ImageLoader;
import javafx.scene.image.Image;

public class Mermaid extends Card {

        public Mermaid() {
        super(CardType.MERMAID, ImageLoader.MERMAID);
        this.pointValue += 5;
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
        return "Mermaid - No effect. But are avereage +5 higher value";
    }
}
