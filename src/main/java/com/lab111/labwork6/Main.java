package main.java.com.lab111.labwork6;

import article.GUI.GUI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(new Rectangle(200, 50, 1200, 700));
        Action action = new Action();
        Filler.fillGUI(gui, action);
    }
}
