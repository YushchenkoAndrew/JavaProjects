package main.java.com.lab111.labwork4;

        import article.GUI.GUI;

        import java.awt.Rectangle;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(new Rectangle(200, 50, 1200, 700));
        Action action = new Action();
        Draw draw = new Draw();
        Filler.fillGUI(gui, action, draw);
    }
}
