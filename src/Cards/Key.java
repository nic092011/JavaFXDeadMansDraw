package Cards;

public class Key extends Card{
        public Key() {
        super("Key");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public String getImage() {
        return "Key.png";

    }

}
