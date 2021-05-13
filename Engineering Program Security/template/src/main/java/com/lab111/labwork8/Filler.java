package main.java.com.lab111.labwork8;

import article.GUI.GUI;
import article.RainbowColors;

import javax.swing.*;
import java.awt.Rectangle;
import java.awt.*;

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


        gui.addInPanel(gui.createButton(new Rectangle(30, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Pencil.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(30, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Eraser.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(60, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Line.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(60, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Oval.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(90, 20, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Rectangle.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(90, 50, 25, 25), true, new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Triangle.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(150, 25, 100, 55), true,new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Select.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(620, 15, 25, 25), true,new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\FillColor.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(270, 25, 40, 60), true,new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Past.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(312, 25, 55, 22), true,new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Copy.png")), 0);

        gui.addInPanel(draw, 1);

        int buttonX = 400;
        int buttonY = 15;
        int buttonLength = 15;
        RainbowColors colors = new RainbowColors();
        colors.setStep(Math.PI / 27);

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 10; j++) {
                gui.addInPanel(gui.createButton(new Rectangle(buttonX + buttonLength * j + 5 * j, buttonY + buttonLength * i + 5 * i, buttonLength, buttonLength), true, ""), 0);
                gui.buttons[j + i * 10 + 10].setColor(colors.getColor());

            }

        action.connection(draw);
        gui.mouseEvent();
        gui.repaint();
    }

    public static void addDynamicElements(GUI gui, double data) {
        gui.addInPanel(gui.createTextField(new Rectangle(710, 25, 40, 25), false, "Size", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(750, 25, 70, 25), true, Double.toString(data), true), 0);
        gui.addInPanel(gui.createButton(new Rectangle(750, 55, 70, 25), true, "Load"), 0);
        gui.addInPanel(gui.createButton(new Rectangle(605, 45, 25, 25), true,new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Rotate1.png")), 0);
        gui.addInPanel(gui.createButton(new Rectangle(635, 45, 25, 25), true,new ImageIcon("src\\main\\java\\com\\lab111\\labwork8\\Pictures\\Rotate2.png")), 0);


        gui.repaint();
    }

    public static void removeDynamicElements(GUI gui) {
        gui.removeFromPanel(gui.textFields[1].getTextField(), 0);
        gui.removeFromPanel(gui.textFields[0].getTextField(), 0);
        gui.removeFromPanel(gui.buttons[50].getjButton(), 0);
        gui.removeFromPanel(gui.buttons[51].getjButton(), 0);
        gui.removeFromPanel(gui.buttons[52].getjButton(), 0);

//        gui.indexButton -= 3;
//        gui.sizeTextField -= 2;

        gui.repaint();
    }
}
