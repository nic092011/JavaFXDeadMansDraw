package Cards;

import java.util.Random;

import javafx.scene.image.Image;




abstract public class Card {

    protected CardType type;
    protected int pointValue;
    protected Image image;

    public Card(CardType type, Image image) {
        this.type = type;
        this.image = image;
        
        //Generate point Value
        Random random = new Random();
        this.pointValue = random.nextInt(10) + 1;
    }

    public abstract Boolean useAbility();

    public abstract Image getImage();

    public abstract CardType getCardType();


}
