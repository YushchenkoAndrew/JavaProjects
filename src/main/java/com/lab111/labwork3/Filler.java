package main.java.com.lab111.labwork3;

import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Filler {
    public static void fillGUI (GUI gui, Action action) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);
        gui.setAction(action);

        gui.createPane("Properties", new Rectangle(2, 2, 250, 660), null);
        gui.arrayPanel[0].setColor(new Color(254, 249, 231));

        int textFieldPaneHeight = 20;
        int textFieldPaneX1 = 15;
        int textFieldPaneX2 = 55;
        int textFieldPaneY = 45;
        int textFieldPaneWidth1 = 30;
        int textFieldPaneWidth2 = 140;

        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Path", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY, textFieldPaneWidth2 + 45, textFieldPaneHeight),
                true, "D:\\Pictures\\mwyjz6ei9v621.jpg", true), 0);
        gui.addInPanel(gui.createButton(new Rectangle(110, textFieldPaneY + 30, textFieldPaneWidth1 + 20, textFieldPaneHeight),
                true, "Load"), 0);

        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 90, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Size", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 90, textFieldPaneWidth1, textFieldPaneHeight),
                true, "700", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2 + 15, textFieldPaneY + 200, textFieldPaneWidth1 + 50, textFieldPaneHeight),
                true, "Color", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2 + 50, textFieldPaneY + 90, textFieldPaneWidth1, textFieldPaneHeight),
                true, "500", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2 - 15, textFieldPaneY + 385, textFieldPaneWidth2, textFieldPaneHeight),
                false, "r: 242, g: 243, b: 244", true), 0);

        gui.addInPanel(gui.createButton(new Rectangle(150, textFieldPaneY + 90, textFieldPaneWidth1 + 20, textFieldPaneHeight),
                true, "Set"), 0);

        JLabel label = new JLabel("x");
        label.setBounds(new Rectangle(textFieldPaneX2 + 35, textFieldPaneY + 87, textFieldPaneWidth1, textFieldPaneHeight));
        gui.addInPanel(label, 0);

        gui.add(gui.createLabel(new Rectangle(252, 2, 932, 660), "", true, null));

        gui.addInPanel(gui.createLabel(new Rectangle(textFieldPaneX2 - 20, textFieldPaneY + 230, 150, 150), "", true, new Color( 242, 243, 244)), 0);

        gui.mouseEvent();
        gui.repaint();
    }
}
