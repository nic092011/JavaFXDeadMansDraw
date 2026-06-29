package Cards;

import java.util.ArrayList;
import java.util.HashMap;

import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Hook extends Card {

    public Hook(Game game) {
        super(CardType.HOOK, ImageLoader.HOOK, game);
    }

    // Find the highest cards to show from the bank
    @Override
    public Boolean useAbility() {
        HashMap<CardType, Card> highestCards = new HashMap<>();
        ArrayList<Card> cardsFromBank = new ArrayList<>();
        // for each card in bank
        for (Card card : game.getCurrentPlayer().getBank()) {
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
        return "Hook - Select a highest-value card from your Bank:";
    }

}
