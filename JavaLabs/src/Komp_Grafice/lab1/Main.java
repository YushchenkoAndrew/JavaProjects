package Komp_Grafice.lab1;

import article.GUI.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(new Rectangle(300, 150, 500, 500));
        Draw draw = new Draw();

        Filler.fillGUI(gui, draw);

    }
}
