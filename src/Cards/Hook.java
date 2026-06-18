package Cards;

public class Hook extends Card{
        public Hook() {
        super("Hook");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public String getImage() {
        return "Hook.png";

    }

}
