package main.java.com.lab111.labwork7;

import article.GUI.GUI;
import article.RainbowColors;

import javax.swing.*;
import java.awt.*;
import java.awt.Rectangle;

public class Filler {
    public static void fillGUI(GUI gui, Action action, Draw draw) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);
        gui.setAction(action);

        gui.createPane("Elements", new Rectangle(2, 2, 1180, 100));
        gui.createPane("Field", new Rectangle(2, 100, 1180, 560));

        gui.arrayPanel[0].setLayoutManager(null);
        gui.arrayPanel[1].setLayoutManager(new BorderLayout());

        gui.arrayPanel[0].setColor(new Color( 235, 245, 251 ));
        gui.arrayPanel[1].setColor(new Color(255, 255, 255));


        gui.addInPanel(gui.createButton(new Rectangle(30, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork7\\Pictures\\Pencil.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(30, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork7\\Pictures\\Eraser.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(60, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork7\\Pictures\\Line.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(60, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork7\\Pictures\\Oval.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(90, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork7\\Pictures\\Rectangle.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(90, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork7\\Pictures\\Triangle.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(150, 25, 100, 55), true,new ImageIcon("src\\main\\java\\com\\lab111\\labwork7\\Pictures\\Select.png")), 0);

        gui.addInPanel(draw, 1);

        int buttonX = 300;
        int buttonY = 15;
        int buttonLength = 15;
        RainbowColors colors = new RainbowColors();
        colors.setStep(Math.PI / 27);

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 10; j++) {
                gui.addInPanel(gui.createButton(new Rectangle(buttonX + buttonLength * j + 5 * j, buttonY + buttonLength * i + 5 * i, buttonLength, buttonLength), true, ""), 0);
                gui.buttons[j + i * 10 + 7].setColor(colors.getColor());

            }

        action.connection(draw);
        gui.mouseEvent();
        gui.repaint();
    }
}
