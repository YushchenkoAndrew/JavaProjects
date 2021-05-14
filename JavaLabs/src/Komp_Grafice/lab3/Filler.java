package Komp_Grafice.lab3;

import article.ActionEvent.ActionEvent;
import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Filler {
    public static void fillGUI(GUI gui, Action action, Draw draw) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setAction(action);

        int textFieldPaneHeight = 20;
        int textFieldPaneX1 = 15;
        int textFieldPaneX2 = 55;
        int textFieldPaneY = 45;
        int textFieldPaneWidth1 = 30;
        int textFieldPaneWidth2 = 140;

        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY, textFieldPaneWidth1, textFieldPaneHeight),
                false, "H", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY, textFieldPaneWidth2, textFieldPaneHeight),
                true, "15", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 20, textFieldPaneWidth1, textFieldPaneHeight),
                false, "R", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 20, textFieldPaneWidth2, textFieldPaneHeight),
                true, "100", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 40, textFieldPaneWidth1, textFieldPaneHeight),
                false, "X", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 40, textFieldPaneWidth2, textFieldPaneHeight),
                true, "0", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 60, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Y", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 60, textFieldPaneWidth2, textFieldPaneHeight),
                true, "0", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 80, textFieldPaneWidth1, textFieldPaneHeight),
                false, "MAX", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 80, textFieldPaneWidth2, textFieldPaneHeight),
                false, "", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 100, textFieldPaneWidth1, textFieldPaneHeight),
                false, "MIN", true));
        gui.add(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 100, textFieldPaneWidth2, textFieldPaneHeight),
                false, "", true));
        gui.add(gui.createButton(new Rectangle(textFieldPaneX1 + 70, textFieldPaneY + 130, textFieldPaneWidth1 + 30, textFieldPaneHeight),
                true, "Load"));
        gui.add(gui.createButton(new Rectangle(textFieldPaneX1 + 70, textFieldPaneY + 160, 25, 25),
                true, new ImageIcon("src\\Komp_Grafice\\lab3\\Pictures\\Zoom1.png")));
        gui.add(gui.createButton(new Rectangle(textFieldPaneX1 + 100, textFieldPaneY + 160, 25, 25),
                true, new ImageIcon("src\\Komp_Grafice\\lab3\\Pictures\\Zoom2.png")));


        gui.add(draw);

        action.connection(draw);

        gui.mouseEvent();
        gui.repaint();
    }
}
