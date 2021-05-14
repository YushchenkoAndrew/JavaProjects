package Komp_Grafice.lab6;

import article.ActionEvent.ActionEvent;
import article.GUI.GUI;

import javax.swing.*;
import java.awt.*;

public class Filler {
    public static void fillGUI(GUI gui, Action action, Draw draw) {
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setLayout(null);
        gui.setAction(action);
        int textFieldPaneHeight = 20;
        int textFieldPaneX1 = 15;
        int textFieldPaneX2 = 50;
        int textFieldPaneY = 20;
        int textFieldPaneWidth1 = 30;
        int textFieldPaneWidth2 = 50;

        gui.createPane("Parameters", new Rectangle(2, 2, 170, 460), null);
        gui.createPane("Traces", new Rectangle(174, 2, 510, 460), new BorderLayout());

        gui.arrayPanel[0].setColor(new Color(254, 249, 231));
        gui.arrayPanel[1].setColor(new Color(255, 255, 255));

        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY, textFieldPaneWidth1, textFieldPaneHeight),
                false, "X", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY, textFieldPaneWidth2, textFieldPaneHeight),
                true, "100", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 20, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Y", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 20, textFieldPaneWidth2, textFieldPaneHeight),
                true, "100", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 40, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Z", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 40, textFieldPaneWidth2, textFieldPaneHeight),
                true, "150", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 60, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Sp", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 60, textFieldPaneWidth2, textFieldPaneHeight),
                true, "1", true), 0);
        gui.addInPanel(gui.createButton(new Rectangle(110, 25, 45, 25), true,  "Load"), 0);


        gui.addInPanel(draw, 1);

        gui.mouseEvent();

        action.setDraw(draw);
        gui.repaint();
    }
}
