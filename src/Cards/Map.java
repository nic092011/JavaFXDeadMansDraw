package Cards;

public class Map extends Card{
        public Map() {
        super("Map");
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public String getImage() {
        return "Map.png";

    }

}
