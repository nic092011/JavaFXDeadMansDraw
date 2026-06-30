package Cards;

import java.util.ArrayList;
import java.util.HashMap;

import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Sword extends Card {


    public Sword(Game game) {
        super(CardType.SWORD, ImageLoader.SWORD, game);
    }


    @Override
    public Boolean useAbility() {
        HashMap<CardType, Card> highestCards = new HashMap<>();
        ArrayList<Card> cardsFromBank = new ArrayList<>();
        // for each card in opponents bank
        for (Card card : game.getCurrentOpponent().getBank()) {
            CardType type = card.getCardType();

            //check if card type is present and if point value is higher
            if (!highestCards.containsKey(type) || card.getPointValue() > highestCards.get(type).getPointValue()) {
                highestCards.put(type, card);
            }
            

        }
        cardsFromBank.addAll(highestCards.values());
        



        game.showNextCards(cardsFromBank);
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
        return "Sword - Select a card from the opponents Bank and put into your Play Area:";
    }

}
