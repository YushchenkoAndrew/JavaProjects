package Komp_Grafice.lab6;

import article.GUI.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(new Rectangle(300, 150, 700, 500));
        Action action = new Action();
        Draw draw = new Draw();
        Filler.fillGUI(gui, action, draw);
    }
}
