package Cards;


import javafx.scene.image.Image;

public class Mermaid extends Card {
        private final Image mermaid = new Image(getClass().getResource("/images/Mermaid.png").toExternalForm());

        public Mermaid() {
        super("Mermaid");
        this.pointValue += 3;
    }

    @Override
    public Boolean useAbility() {
        return true;
    }

    @Override
public Image getImage() {
    return mermaid;
}

}
