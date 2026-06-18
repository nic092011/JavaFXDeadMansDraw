package Cards;

public class Chest extends Card{
        public Chest() {
        super("Chest");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public String getImage() {
        return "Chest.png";

    }

}
