package Cards;

public class Cannon extends Card {
    public Cannon() {
        super("Cannon");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public String getImage() {
        return "Cannon.png";

    }
}
