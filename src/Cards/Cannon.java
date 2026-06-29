package Cards;


import Game.Game;
import UI.ImageLoader;
import javafx.scene.image.Image;

public class Cannon extends Card {
        

    public Cannon(Game game) {
        super(CardType.CANNON, ImageLoader.CANNON, game);
    }

    @Override
    public Boolean useAbility() {

        if (game.getCurrentOpponent().getBank().isEmpty()) {
            return false;
        }

        Card highestCard = null;
        for (Card card : game.getCurrentOpponent().getBank()) {
            if (highestCard == null || card.getPointValue() > highestCard.getPointValue()) {
                highestCard = card;
            }

        }
        if (highestCard != null) {
            game.getCurrentOpponent().getBank().remove(highestCard);
            game.getDiscard().add(highestCard);
        } 

        game.getCurrentOpponent().getBankPoints();
        game.updateScore();
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
