package Cards;

import java.util.Random;

import javafx.scene.image.Image;
import Game.Game;



abstract public class Card {

    protected CardType type;
    protected int pointValue;
    protected Image image;
    protected Game game;

    public Card(CardType type, Image image, Game game) {
        this.type = type;
        this.image = image;
        this.game = game;
        
        //Generate point Value
        Random random = new Random();
        this.pointValue = random.nextInt(8) + 1;
    }

    public abstract Boolean useAbility();

    public abstract Image getImage();

    public abstract CardType getCardType();

    public abstract String getAbilityString();

    public int getPointValue() {
        return this.pointValue;
    }


}
