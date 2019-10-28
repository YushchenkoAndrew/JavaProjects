package main.java.com.lab111.labwork4;

import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;

public class Filler {
    public static void fillGUI(GUI gui, Action action, Draw draw) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(new BorderLayout());
        gui.setAction(action);

//        gui.createPane("Elements", new Rectangle(2, 2, 1180, 100));

        gui.add(gui.createButton(new Rectangle(30, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork4\\Pictures\\Pencil.png")));
        gui.add(gui.createButton(new Rectangle(30, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork4\\Pictures\\Eraser.png")));
        gui.add(gui.createButton(new Rectangle(60, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork4\\Pictures\\Line.png")));
        gui.add(gui.createButton(new Rectangle(60, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork4\\Pictures\\Oval.png")));
        gui.add(gui.createButton(new Rectangle(90, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork4\\Pictures\\Rectangle.png")));
        gui.add(gui.createButton(new Rectangle(90, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork4\\Pictures\\Triangle.png")));
        gui.add(gui.createButton(new Rectangle(150, 35, 100, 25), true, "special effect"));
        gui.add(draw);

        action.connection(draw);
        gui.mouseEvent();
        gui.repaint();
    }
}
