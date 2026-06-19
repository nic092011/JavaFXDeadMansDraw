package Cards;


import UI.ImageLoader;
import javafx.scene.image.Image;

public class Mermaid extends Card {

        public Mermaid() {
        super(CardType.MERMAID, ImageLoader.MERMAID);
        this.pointValue += 3;
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

}
