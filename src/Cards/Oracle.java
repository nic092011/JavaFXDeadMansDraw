package Cards;


import javafx.scene.image.Image;

public class Oracle extends Card{
        private final Image oracle = new Image(getClass().getResource("/images/Oracle.png").toExternalForm());


    public Oracle() {
        super("Oracle");
    }


    @Override
    public Boolean useAbility() {
        return true;
    }


    @Override
public Image getImage() {
    return oracle;
}

}



