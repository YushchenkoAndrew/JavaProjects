package Komp_Grafice.lab7;

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
                true, "50", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 20, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Y", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 20, textFieldPaneWidth2, textFieldPaneHeight),
                true, "50", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 40, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Z", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 40, textFieldPaneWidth2, textFieldPaneHeight),
                true, "70", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 60, textFieldPaneWidth1, textFieldPaneHeight),
                false, "Sp", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 60, textFieldPaneWidth2, textFieldPaneHeight),
                true, "50", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 80, textFieldPaneWidth1, textFieldPaneHeight),
                false, "K", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 80, textFieldPaneWidth2, textFieldPaneHeight),
                true, "40", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 100, textFieldPaneWidth1, textFieldPaneHeight),
                false, "I", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 100, textFieldPaneWidth2, textFieldPaneHeight),
                true, "255", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX1, textFieldPaneY + 120, textFieldPaneWidth1, textFieldPaneHeight),
                false, "N", true), 0);
        gui.addInPanel(gui.createTextField(new Rectangle(textFieldPaneX2, textFieldPaneY + 120, textFieldPaneWidth2, textFieldPaneHeight),
                true, "2", true), 0);
        gui.addInPanel(gui.createButton(new Rectangle(110, 85, 45, 25), true,  "Load"), 0);
        gui.buttons[0].setFont(new Font(Font.DIALOG, Font.BOLD, 12));

        gui.addInPanel(gui.createLabel(new Rectangle(50, 165, 100, 20), "Rotation Axes", true, new Color(254, 249, 231)),0);
        gui.label[0].setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        gui.createButtonGroup();
        gui.addInPanel(gui.createRadioButton(new Rectangle(20, 185, 100, 20), "OX", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(20, 205, 100, 20), "OY", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(20, 225, 100, 20), "OZ", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(20, 245, 100, 20), "OX-OY", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(20, 265, 100, 20), "OY-OZ", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(20, 285, 100, 20), "OX-OZ", true, new Color(254, 249, 231), 0), 0);
        gui.addInPanel(gui.createRadioButton(new Rectangle(20, 305, 100, 20), "OX-OY-OZ", true, new Color(254, 249, 231), 0), 0);

        gui.radioButtons[0].setSelected(true);
        for (int i = 0; i < 7; i++)
            gui.radioButtons[i].setFont(new Font(Font.SANS_SERIF, Font.ITALIC, 14));

        gui.addInPanel(draw, 1);

        gui.mouseEvent();

        action.setDraw(draw);
        gui.repaint();
    }
}
