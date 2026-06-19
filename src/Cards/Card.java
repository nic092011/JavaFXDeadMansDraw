package Cards;

import java.util.Random;

import javafx.scene.image.Image;




abstract public class Card {
    String cardSuit;
    int pointValue;
    String Image;
    public Card(String cardSuit) {
        this.cardSuit = cardSuit;
        
        Random random = new Random();
        this.pointValue = random.nextInt(10) + 1;
    }

    public abstract Boolean useAbility();

    public abstract Image getImage();



}
