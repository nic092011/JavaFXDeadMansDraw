package Cards;

public class Mermaid extends Card {
        public Mermaid() {
        super("Mermaid");
        this.pointValue += 3;
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
    public String getImage() {
        return "Mermaid.png";

    }

}
