package Cards;

public class Oracle extends Card{

    public Oracle() {
        super("Oracle");
    }


    @Override
    public Boolean useAbility() {
        return true;
    }


    @Override
    public String getImage() {
        return "Oracle.png";
    }

}



