package Game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

import Cards.Card;

public class Player {

    ArrayList<Card> hand = new ArrayList<>();
    ArrayList<Card> bank = new ArrayList<>();
    ArrayList<Card> playArea = new ArrayList<>();

    String name;
    int currentScore;

    public void addToBank() {
        bank.addAll(playArea);
    }

    public ArrayList<ImageView> printHand() {

        ArrayList<ImageView> handToPrint = new ArrayList<>();

         for (Card  c : hand){
            Image img = c.getImage();


            //image sizes and affects
            ImageView iView = new ImageView(img); 
            iView.setFitWidth(100);
            iView.setFitHeight(150);


            handToPrint.add(iView);

        }

        
        return handToPrint;

    }

    

}
