package UI;


import javafx.scene.image.Image;

public class ImageLoader {

    public static final Image SWORD = load("Sword.png");
    public static final Image CHEST = load("Chest.png");
    public static final Image HOOK = load("Hook.png");
    public static final Image KEY = load("Key.png");
    public static final Image MAP = load("Map.png");
    public static final Image MERMAID = load("Mermaid.png");
    public static final Image ORACLE = load("Oracle.png");
    public static final Image CANNON = load("Cannon.png");
    public static final Image BACK = load("Back.jpg");
    

        private static Image load(String path) {
        return new Image(ImageLoader.class.getResourceAsStream("/Images/" + path));
    }

}
