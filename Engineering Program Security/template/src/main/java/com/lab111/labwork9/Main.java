package main.java.com.lab111.labwork9;

import article.GUI.GUI;
import article.MainStructure;

import java.awt.Rectangle;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(new Rectangle(200, 50, 1200, 700));
        Action action = new Action();
        MainStructure structure = new Structure();
        structure.setGuisAndActionEvent(gui, action);
        Draw draw = new Draw();
        Filler.fillGUI(gui, action, draw);
    }
}
