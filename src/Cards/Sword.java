package Cards;

public class Sword extends Card {

    public Sword() {
        super("Sword");
    }


    @Override
    public Boolean useAbility() {
        return true;
    }


    @Override
    public String getImage() {
        return "Sword.png";
    }

}
